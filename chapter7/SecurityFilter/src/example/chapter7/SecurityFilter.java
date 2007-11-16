package example.chapter7;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // 在此初始化Filter
    }

    public void destroy() {
        // 在此释放资源
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse)response).sendError(403);
        chain.doFilter(request, response);
    }

}
