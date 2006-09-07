package com.crackj2ee.bookstore.web.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.crackj2ee.bookstore.business.BusinessService;
import com.crackj2ee.bookstore.util.HttpUtil;

/**
 * Try to auto-login.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="autoLoginInterceptor"
 */
public class AutoLoginHandlerInterceptor implements HandlerInterceptor {

    private BusinessService businessService;

    private final Log log = LogFactory.getLog(getClass());

    private static final String SESSION_FIRST_VISIT = "sf_1st_visit";

    /**
     * Inject BusinessService object. All DAO operations are wrapped in 
     * this core interface.
     * 
     * @spring.property ref="businessService"
     */
    public final void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Identity identity = HttpUtil.getIdentityFromSession(request.getSession());
        if(identity==null) {
            // try to auto login:
            HttpSession session = request.getSession();
            if(session.getAttribute(SESSION_FIRST_VISIT)==null) {
                // first time to visit:
                session.setAttribute(SESSION_FIRST_VISIT, Boolean.TRUE);
                // try to read cookie:
                String[] login = HttpUtil.getUsernameAndPasswordByCookie(request);
                if(login!=null) {
                    try {
                        identity = new AccountIdentity(businessService.login(login[0], login[1]));
                        HttpUtil.bindIdentityToSession(session, identity);
                        log.info("Login by cookie successfully.");
                    }
                    catch(Exception e) {
                        log.info("Login by cookie failed.");
                        // clear cookie if login failed:
                        response.addCookie(HttpUtil.CLEAR_USERNAME);
                    }
                }
            }
        }
        HttpUtil.bindIdentityToThreadLocal(identity);
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /* ignore */
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /* ignore */
    }

}
