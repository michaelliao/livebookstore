package example.chapter7;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle all exception.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="handlerExceptionResolver"
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    private Log log = LogFactory.getLog(getClass());

    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        log.warn("Handle exception: " + ex.getClass().getName());
        // 如果抛出NeedLoginException,就将用户导向到登录页面:
        if(ex instanceof NeedLoginException)
            return new ModelAndView("redirect:login.do");
        // 对于其他Exception,在/error.jsp中显示Exception的信息:
        Map model = new HashMap();
        model.put("ex", ex.getClass().getSimpleName());
        model.put("message", ex.getMessage());
        return new ModelAndView("error", model);
    }

}
