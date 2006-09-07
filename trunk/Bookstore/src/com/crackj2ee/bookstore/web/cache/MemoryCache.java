package com.crackj2ee.bookstore.web.cache;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller which implements this interface will have memory cache ability 
 * automatically.
 * 
 * @author xuefeng
 */
public interface MemoryCache {

    /**
     * Return the unique page key, or null if do not want to cache it.
     * 
     * @return Unique page key, or null if do not need cache.
     */
    String getCacheKey(HttpServletRequest request);

    /**
     * Get cache time in seconds.
     * 
     * @return How many seconds to cache in memory. Must be positive to work correctly.
     */
    int getCacheTime();

}
