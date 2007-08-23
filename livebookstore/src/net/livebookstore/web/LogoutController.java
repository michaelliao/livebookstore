package net.livebookstore.web;

import javax.servlet.http.*;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractRedirectController;

/**
 * Do user logout. Use Acegi LogoutFilter instead.
 * 
 * @author xuefeng
 * 
 * @deprecated
 */
public class LogoutController extends AbstractRedirectController {

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

    public String redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = HttpUtil.getString(request, "url", "listBooks.jspx");
        // remove identity from session:
        //HttpUtil.unbindIdentityFromSession(request.getSession());
        // clear cookies:
        response.addCookie(COOKIE_U);
        response.addCookie(COOKIE_P);
        return url;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
