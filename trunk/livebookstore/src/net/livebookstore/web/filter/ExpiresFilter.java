package net.livebookstore.web.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Set http response's expires information so that client can cache resources 
 * safely.
 * 
 * @author Xuefeng
 */
public class ExpiresFilter implements Filter {

    private Log log = LogFactory.getLog(getClass());

    private Map<String, Long> map = new HashMap<String, Long>();

    @SuppressWarnings("unchecked")
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration en = filterConfig.getInitParameterNames();
        while(en.hasMoreElements()) {
            String paramName = en.nextElement().toString();
            String paramValue = filterConfig.getInitParameter(paramName);
            try {
                int time = Integer.valueOf(paramValue);
                if(time>0) {
                    log.info("Set " + paramName + " expired in seconds: " + time);
                    map.put(paramName, new Long(time));
                }
            }
            catch(Exception e) {
                log.warn("Exception in initilazing ExpiredFilter.", e);
            }
        }
    }

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest)request).getRequestURI();
        int n = uri.lastIndexOf('.');
        if(n!=(-1)) {
            String ext = uri.substring(n);
            Long exp = map.get(ext);
            if(exp!=null) {
                HttpServletResponse resp = (HttpServletResponse)response;
                resp.setHeader("Cache-Control", "max-age=" + exp);
                resp.setDateHeader("Expires", System.currentTimeMillis() + exp * 1000);
            }
        }
        chain.doFilter(request, response);
    }

}
