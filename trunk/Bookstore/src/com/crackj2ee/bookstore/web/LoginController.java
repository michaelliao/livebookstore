package com.crackj2ee.bookstore.web;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.*;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.*;

/**
 * User login controller.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="loginController" name="/login.jspx"
 */
public class LoginController extends AbstractMvcController {

    private static final int MAX_AGE = 3600 * 24 * 30 * 12; // 1 year

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = HttpUtil.getString(request, "username");
        String password = HttpUtil.getString(request, "password");
        boolean remember = HttpUtil.getBoolean(request, "remember", false);
        String url = HttpUtil.getString(request, "url", "listBooks.jspx");
        log.info("Try to login with username [" + username + "], password [" + password + "]...");
        Account account = businessService.login(username, password);
        log.info("Login successfully.");
        HttpUtil.bindIdentityToSession(request.getSession(), new AccountIdentity(account));
        if(remember) {
            // store username & password in cookies:
            Cookie u = new Cookie("username", username);
            Cookie p = new Cookie("password", password);
            u.setMaxAge(MAX_AGE);
            p.setMaxAge(MAX_AGE);
            u.setPath("/");
            p.setPath("/");
            response.addCookie(u);
            response.addCookie(p);
        }
        // jump to previous page, or home page if url is not specified:
        log.info("redirect to: " + url);
        response.sendRedirect(url);
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/login.html";
    }

    public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        response.sendRedirect("login.html?error=" + URLEncoder.encode(e.getMessage(), "UTF-8"));
    }

}
