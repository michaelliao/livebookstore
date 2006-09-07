package com.crackj2ee.bookstore.web.core;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * Template for script output controller.
 * 
 * @author xuefeng
 */
public abstract class AbstractScriptController extends AbstractController {

    public final ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String script = getScript(request, response);
        response.setContentType("text/javascript;charset=UTF-8");
        int cache = getCacheTime(request, response);
        if(cache<=0)
            response.setHeader("Cache-Control", "no-cache");
        else {
            response.setHeader("Cache-Control", "Private");
            response.addDateHeader("Expires", System.currentTimeMillis() + 1000 * cache);
        }
        PrintWriter writer = response.getWriter();
        writer.write(script);
        writer.flush();
        return null;
    }

    /**
     * Get script content. such as "document.write()".
     */
    public abstract String getScript(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * Get cache time. How many seconds to cache in client.
     */
    public abstract int getCacheTime(HttpServletRequest request, HttpServletResponse response);

}
