package com.crackj2ee.bookstore.web.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractRedirectController extends AbstractController {

    @Override
    public final ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // handle request:
            handle(request, response);
            String url = getRedirectUrl(request, response);
            response.sendRedirect(url);
        }
        catch(Exception e) {
        }
        return null;
    }

    /**
     * Handle request.
     */
    protected abstract void handle(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * Get redirect url if no exception.
     */
    protected abstract String getRedirectUrl(HttpServletRequest request, HttpServletResponse response);
}
