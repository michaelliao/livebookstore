package com.crackj2ee.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.*;

import org.apache.commons.logging.*;

/**
 * This filter do some pre-handle task, such as set request's character encoding.
 * 
 * @author xuefeng
 */
public class GlobalFilter implements Filter {

    private Log log = LogFactory.getLog(getClass());

    private String encoding = "UTF-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Init GlobalFilter...");
        String encoding = filterConfig.getInitParameter("encoding");
        if(encoding!=null && !"".equals(encoding.trim()))
            this.encoding = encoding.trim();
        log.info("Request character encoding is set to " + encoding);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // set encoding:
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void destroy() {
        log.info("GlobalFilter destroyed.");
    }

}
