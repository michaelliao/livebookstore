package net.livebookstore.web.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.HttpUtil;

/**
 * This is global exception resolver to handle exception thrown by controllers.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="handlerExceptionResolver"
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    private final Log log = LogFactory.getLog(GlobalHandlerExceptionResolver.class);

    @SuppressWarnings("unchecked")
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = HttpUtil.getURL(request);
        log.warn("Exception from URL: " + url, ex);
        Map map = new HashMap();
        String message = ex.getMessage();
        map.put("url", url);
        map.put("message", message==null ? "(未知错误)" : message);
        if(SecurityUtil.isAdminRole()) {
            StringBuffer sb = new StringBuffer(1024);
            for(StackTraceElement ste : ex.getStackTrace()) {
                sb.append("at ").append(ste.getClassName())
                    .append('.').append(ste.getMethodName());
                String file = ste.getFileName();
                if(file!=null) {
                    int line = ste.getLineNumber();
                    if(line>0)
                        sb.append("(" + file + ":" + line + ")");
                    else 
                        sb.append("(" + file + ")");
                }
                sb.append('\n');
            }
            map.put("class", ex.getClass().getName());
            map.put("stack", sb.toString());
        }
        return new ModelAndView("/error.html", map);
    }

}
