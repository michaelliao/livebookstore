package net.livebookstore.web.filter;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.util.FileUtil;
import net.livebookstore.util.GZipUtil;

import org.springframework.core.io.Resource;

/**
 * Do file cache. This filter is configured by FilterToBeanProxy.
 * 
 * @author Xuefeng
 */
public class FileCacheFilter extends AbstractCacheFilter {

    private String root;
    private final String SUFFIX = ".html";

    /**
     * Set cached files' root directory. e.g.: /static/
     */
    public final void setFileDir(Resource dir) {
        try {
            File f = dir.getFile();
            f.mkdirs();
            if(!f.isDirectory())
                throw new IllegalArgumentException("Invalid directoy: " + f.getPath());
            if(!f.canWrite())
                throw new IllegalArgumentException("Cannot write to directory: " + f.getPath());
            root = f.getPath();
            // make sure root is end with "/":
            if(!root.endsWith("/") && !root.endsWith("//"))
                root = root + "/";
        }
        catch(IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        if(!new File(root).isDirectory()) {
            throw new IllegalArgumentException("No directory: " + root);
        }
    }

    public void remove(String url, Map<String, String> parameters) {
        String key = getKey(HttpServletRequestFactory.create(url, parameters));
        if(key!=null) {
            FileUtil.removeFile(key2File(key));
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // check if there is static html file:
        String key = getKey(httpRequest);
        if(key==null) {
            // not match the definition!
            chain.doFilter(request, response);
        }
        else {
            File file = key2File(key);
            if(file.isFile()) {
                log.info("Load cached file from: " + file.getPath());
                HttpServletResponse httpResponse = (HttpServletResponse)response;
                httpResponse.setContentType(getContentType());
                httpResponse.setHeader("Content-Encoding", "gzip");
                httpResponse.setContentLength((int)file.length());
                FileUtil.readFile(file, httpResponse.getOutputStream());
            }
            else {
                log.info("Cannot find cached file. Create new cached file...");
                HttpServletResponse httpResponse = (HttpServletResponse)response;
                CachedResponseWrapper wrapper = new CachedResponseWrapper(httpResponse);
                chain.doFilter(request, wrapper);
                if(wrapper.getStatus()==HttpServletResponse.SC_OK) {
                    byte[] data = GZipUtil.gzip(wrapper.getResponseData());
                    FileUtil.writeFile(file, data);
                    log.info("Page is cached to file.");
                    // now send response to client:
                    httpResponse.setContentType(getContentType());
                    httpResponse.setContentLength(data.length);
                    httpResponse.setHeader("Content-Encoding", "gzip");
                    ServletOutputStream output = response.getOutputStream();
                    output.write(data);
                    output.flush();
                }
                else {
                    log.warn("Cannot cache page because response code is not 200.");
                }
            }
        }
    }

    private File key2File(String key) {
        int hash = key.hashCode();
        int dir1 = (hash & 0xff00) >> 8;
        int dir2 = hash & 0xff;
        String dir = root + dir1 + "/" + dir2;
        File fdir = new File(dir);
        if(!fdir.isDirectory()) {
            if(!fdir.mkdirs())
                return null;
        }
        return new File(dir + "/" + encode(key) + SUFFIX);
    }

    private String encode(String key) {
        try {
            return URLEncoder.encode(key, "UTF-8");
        }
        catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
