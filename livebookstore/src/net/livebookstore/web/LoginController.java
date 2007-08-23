package net.livebookstore.web;

import javax.servlet.http.*;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.*;

/**
 * User login controller. Using Acegi's authentication filter instead.
 * 
 * @author xuefeng
 * 
 * @deprecated
 */
public class LoginController extends AbstractRedirectController {

    private static final int MAX_AGE = 3600 * 24 * 30 * 12; // 1 year

    public String redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = HttpUtil.getString(request, "username");
        String password = HttpUtil.getString(request, "password");
        boolean remember = HttpUtil.getBoolean(request, "remember", false);
        String url = HttpUtil.getString(request, "url", "listBooks.jspx");
        log.info("Try to login with username [" + username + "], password [" + password + "]...");
        //Account account = businessService.login(username, password);
        log.info("Login successfully.");
        //HttpUtil.bindIdentityToSession(request.getSession(), new AccountIdentity(account));
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
        return url;
    }

}
