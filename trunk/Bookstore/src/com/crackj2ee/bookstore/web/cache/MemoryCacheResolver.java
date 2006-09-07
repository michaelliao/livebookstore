package com.crackj2ee.bookstore.web.cache;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import com.crackj2ee.bookstore.util.ZipUtil;
import com.opensymphony.oscache.base.Cache;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Resolve memory cache.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="memoryCacheResolver"
 */
public class MemoryCacheResolver implements InitializingBean {

    public static final int DEFAULT_CAPACITY = 100;

    private Log log = LogFactory.getLog(getClass());
    private int capacity = DEFAULT_CAPACITY;

    private Cache cache = new Cache(
            true, /* useMemoryCaching */
            false, /* unlimitedDiskCache */
            false, /* overflowPersistence */
            false, /* blocking */
            "com.opensymphony.oscache.base.algorithm.LRUCache",
            DEFAULT_CAPACITY);

    public void setCapacity(int max) {
        if(max<1 || max>0xffff)
            capacity = DEFAULT_CAPACITY;
        else
            capacity = max;
    }

    public void afterPropertiesSet() throws Exception {
        cache.setCapacity(capacity);
    }

    public boolean tryOutput(HttpServletResponse response, String key, int expiredTime) {
        byte[] data = null;
        try {
            // Get from the cache
            data = (byte[])cache.getFromCache(key, expiredTime);
        }
        catch (NeedsRefreshException nre) {
            // If a NeedsRefreshException is raised, 
            // you have to invoke cancelUpdate to avoid deadlock situation:
            cache.cancelUpdate(key);
        }
        if(data==null)
            return false;
        // try output:
        response.setHeader("Content-Encoding", "gzip");
        // output:
        OutputStream output = null;
        try {
            output = response.getOutputStream();
            output.write(data);
            output.flush();
        }
        catch (IOException e) {
            log.warn("Output failed.", e);
            try {
                response.sendError(500);
            }
            catch (IOException e1) {}
            return true;
        }
        return true;
    }

    public void put(String key, byte[] data) {
        byte[] compressed = ZipUtil.gzip(data);
        cache.putInCache(key, compressed);
        log.info("Compress to " + compressed.length + " bytes, " + (compressed.length * 100 / data.length)  + "% compressed.");
    }
}
