package com.crackj2ee.bookstore.web.cache;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller which implements this interface will have static-file-cache 
 * automatically.
 * 
 * @author xuefeng
 */
public interface FileCache {

    /**
     * Return the unique page key, or null if do not want to cache it. 
     * NOTE: the unique page key must can be used as file name, so, any 
     * illegal characters such as '*', '?' are not allowed, otherwise, 
     * there will be a failure of creating file. We strongly suggest 
     * only use english letters (a-z), digital numbers (0-9) and '_'. 
     * Notice that Windows platform is case-insensitive, so always use 
     * upper or lower case, not mix them.
     * 
     * @return Unique page key, or null if do not need cache.
     */
    String getCacheKey(HttpServletRequest request);

}
