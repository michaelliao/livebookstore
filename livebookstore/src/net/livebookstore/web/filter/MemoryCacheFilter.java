package net.livebookstore.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.util.GZipUtil;

import com.opensymphony.oscache.base.Cache;
import com.opensymphony.oscache.base.EntryRefreshPolicy;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.web.filter.ExpiresRefreshPolicy;

/**
 * Do memory cache. This filter is configured by FilterToBeanProxy.
 * 
 * @author Xuefeng
 */
public class MemoryCacheFilter extends AbstractCacheFilter {

    private Cache cache;
    private int capacity = 100;
    private long expiresTime = 3600000;
    private EntryRefreshPolicy expiresRefreshPolicy;

    /**
     * Set cache's capacity. Default is 100.
     * 
     * @param capacity Max number of pages that can be cached.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Set cache's expires time. Default is 3600 seconds.
     * 
     * @param expiresTime How long should page cached.
     */
    public void setExpiresTime(int expiresTime) {
        if(expiresTime<1 || expiresTime>3600*24*365)
            throw new IllegalArgumentException("Invalid expiresTime: " + expiresTime);
        this.expiresTime = expiresTime * 1000;
    }

    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        expiresRefreshPolicy = new ExpiresRefreshPolicy((int)(expiresTime / 1000));
        // build cache:
        cache = new Cache(
                true,  /* useMemoryCaching    */
                false, /* unlimitedDiskCache  */
                false, /* overflowPersistence */
                false, /* blocking            */
                "com.opensymphony.oscache.base.algorithm.LRUCache", /* algorithm */
                capacity);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String key = getKey(httpRequest);
        if(key!=null) {
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            log.info("Cache " + httpRequest.getRequestURI() + " with key: " + key);
            try {
                GZipResponseContent content = (GZipResponseContent) cache.getFromCache(key);
                log.info("Cached content found.");
                sendResponse(httpRequest, httpResponse, content);
            }
            catch(NeedsRefreshException e) {
                log.info("Rebuild cache content.");
                boolean updated = false;
                try {
                    CachedResponseWrapper wrapper = new CachedResponseWrapper(httpResponse);
                    chain.doFilter(request, wrapper);
                    if(wrapper.getStatus()!=HttpServletResponse.SC_OK)
                        return;
                    GZipResponseContent newContent = new GZipResponseContent(wrapper.getResponseData());
                    cache.putInCache(key, newContent, expiresRefreshPolicy);
                    updated = true;
                    // send response to client:
                    sendResponse(httpRequest, httpResponse, newContent);
                }
                finally {
                    if(!updated)
                        cache.cancelUpdate(key);
                }
            }
        }
        else {
            // could not cache this page:
            chain.doFilter(request, response);
        }
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response, GZipResponseContent content)
            throws IOException, ServletException
    {
        long ifModifiedSince = request.getDateHeader("If-Modified-Since");
        long lastModified = content.getLastModified();
        if(ifModifiedSince!=(-1) && ifModifiedSince>=lastModified) {
            log.info("Cache found and is still available, send 302 Not Modified.");
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        }
        else {
            byte[] data = content.getData();
            response.setContentType(getContentType());
            response.setContentLength(data.length);
            response.setHeader("Content-Encoding", "gzip");
            response.setHeader("Cache-Control", "max-age=" + (expiresTime / 1000));
            response.setDateHeader("Expires", lastModified + expiresTime);
            ServletOutputStream output = response.getOutputStream();
            output.write(data);
            output.flush();
        }
    }
}

class GZipResponseContent {
    private long lastModified;
    private byte[] data;

    public GZipResponseContent(byte[] data) {
        this.lastModified = System.currentTimeMillis();
        this.data = GZipUtil.gzip(data);
    }

    public long getLastModified() { return lastModified; }
    public byte[] getData() { return data; }
}
