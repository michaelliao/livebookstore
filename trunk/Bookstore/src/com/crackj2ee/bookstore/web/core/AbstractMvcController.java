package com.crackj2ee.bookstore.web.core;

import java.util.Map;

import javax.servlet.http.*;

import org.springframework.web.servlet.ModelAndView;

/**
 * Template class for handling request that DONOT need login.
 * 
 * @author xuefeng
 */
public abstract class AbstractMvcController extends AbstractController {

    @Override
    public final ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // handle request:
            Map map = handle(request, response);
            if(map==null)
                return null;
            String view = getView(request, response);
            if(view==null)
                return null;
            return new ModelAndView(view, map);
        }
        catch(Exception e) {
            handleException(request, response, e);
        }
        return null;
    }

    /**
     * Template for subclass to handle request and expect a Map as model.
     */
    public abstract Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * Get view name.
     */
    public abstract String getView(HttpServletRequest request, HttpServletResponse response);

    /**
     * Default exception handler.
     */
    public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        log.warn("Exception", e);
        throw e;
    }
}
