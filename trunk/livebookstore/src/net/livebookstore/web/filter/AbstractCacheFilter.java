package net.livebookstore.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * Super class for memory cache and file cache, inject CacheDefinition object.
 * 
 * @author Xuefeng
 */
public abstract class AbstractCacheFilter implements Filter, InitializingBean {

    protected Log log = LogFactory.getLog(getClass());

    private String contentType = "text/html;charset=UTF-8";
    private CacheDefinition cacheDefinition;

    public final void setContentType(String contentType) {
        this.contentType = contentType;
    }

    protected final String getContentType() {
        return contentType;
    }

    /**
     * Set cache's definition, each line define a cached page. example:<br/>
     * <code></code><br/>
     * 
     * @param cacheDefinition
     */
    public final void setCacheDefinition(CacheDefinition cacheDefinition) {
        this.cacheDefinition = cacheDefinition;
    }

    /**
     * Get cache key for coming http request, or null if no match.
     * 
     * @param httpRequest The HttpServletRequest object.
     * @return Key of this request, or null if no match.
     */
    protected final String getKey(HttpServletRequest httpRequest) {
        return cacheDefinition.getKey(httpRequest);
    }

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    public void afterPropertiesSet() throws Exception {
        if(cacheDefinition==null)
            throw new NullPointerException("Property cacheDefinition must be set.");
        if(contentType==null || contentType.trim().equals(""))
            throw new NullPointerException("Property contentType is null or empty.");
        contentType = contentType.trim();
    }

}
