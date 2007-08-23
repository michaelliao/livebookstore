package net.livebookstore.web.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

/**
 * Provent user access some files (e.g.: *.htm) directly. Any access to these 
 * resources will cause a 403 Forbidden error.
 * 
 * @author Xuefeng
 */
public class ForbiddenFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // send a 403 error:
        ((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN);
        // after send a 403 error, there is no need to continue the filter chain!
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
