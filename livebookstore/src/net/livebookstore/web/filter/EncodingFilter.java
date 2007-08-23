package net.livebookstore.web.filter;

import java.io.IOException;

import javax.servlet.*;

import org.apache.commons.logging.*;

/**
 * Set request's character encoding. The default encoding is set to UTF-8.
 * 
 * @author xuefeng
 */
public class EncodingFilter implements Filter {

    private Log log = LogFactory.getLog(getClass());

    private String encoding = "UTF-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        String encoding = filterConfig.getInitParameter("encoding");
        if(encoding!=null && !"".equals(encoding.trim()))
            this.encoding = encoding.trim();
        log.info("Request character encoding is set to " + encoding);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void destroy() {
        log.info("EncodingFilter destroyed.");
    }

}
