package com.crackj2ee.bookstore.web.handler;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.crackj2ee.bookstore.exception.LoginFailedException;
import com.crackj2ee.bookstore.exception.NeedLoginException;

/**
 * This is global exception resolver to handle exception thrown by controllers.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="handlerExceptionResolver"
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    private final Log log = LogFactory.getLog(GlobalHandlerExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if(ex instanceof NeedLoginException || ex instanceof LoginFailedException) {
            redirectLogin(response, ex);
            return null;
        }
        // display error:
        Map map = new HashMap();
        return new ModelAndView("/error.html", map);
    }

    private void redirectLogin(HttpServletResponse response, Exception ex) {
        try {
            response.sendRedirect("login.html?error=" + URLEncoder.encode(ex.getMessage(), "UTF-8"));
        }
        catch(Exception e) {
            log.warn("Redirect failed.", e);
        }
    }

}
