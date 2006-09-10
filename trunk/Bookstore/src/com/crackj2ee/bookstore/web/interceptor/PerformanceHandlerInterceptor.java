package com.crackj2ee.bookstore.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Test performance of how long a request handles.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="performanceInterceptor"
 */
public class PerformanceHandlerInterceptor implements HandlerInterceptor {

    private final Log log = LogFactory.getLog(PerformanceHandlerInterceptor.class);

    private static final String START_TIME = "phi_start";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(START_TIME, System.currentTimeMillis());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /* Nothing to do */
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = (Long)request.getAttribute(START_TIME);
        if(startTime!=null) {
            long last = System.currentTimeMillis() - startTime.longValue();
            log.info("Performace: " + last + "ms.");
        }
    }

}
