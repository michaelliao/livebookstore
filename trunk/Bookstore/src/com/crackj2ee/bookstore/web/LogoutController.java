package com.crackj2ee.bookstore.web;

import java.util.Map;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.AbstractMvcController;

/**
 * Do user logout.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="logoutController" name="/logout.jspx"
 */
public class LogoutController extends AbstractMvcController {

    private final Cookie COOKIE_U;
    private final Cookie COOKIE_P;

    public LogoutController() {
        COOKIE_U = new Cookie("username", "$EMPTY$");
        COOKIE_P = new Cookie("password", "$EMPTY$");
        COOKIE_U.setMaxAge(0);
        COOKIE_P.setMaxAge(0);
        COOKIE_U.setPath("/");
        COOKIE_P.setPath("/");
    }

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // remove identity from session:
        HttpUtil.unbindIdentityFromSession(request.getSession());
        // clear cookies:
        response.addCookie(COOKIE_U);
        response.addCookie(COOKIE_P);
        response.sendRedirect(HttpUtil.getString(request, "url", "listBooks.jspx"));
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
