package example.chapter7;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 检测每个请求处理的时间
 * 
 * @spring.bean id="performanceHandler"
 */
public class PerformanceHandlerInterceptor implements HandlerInterceptor {

    private final Log log = LogFactory.getLog(getClass());

    private static final String START_TIME = "PERF_START";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(START_TIME, new Long(System.currentTimeMillis()));
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /* Nothing to do */
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = (Long)request.getAttribute(START_TIME);
        if(startTime!=null) {
            long last = System.currentTimeMillis() - startTime.longValue();
            String uri = request.getRequestURI();
            String query = request.getQueryString();
            if(query!=null)
                uri = uri + '?' + query;
            log.info("URL: " + uri);
            log.info("Execute: " + last + "ms.");
        }
    }

}
