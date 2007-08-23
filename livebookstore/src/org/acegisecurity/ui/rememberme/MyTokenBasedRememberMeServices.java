package org.acegisecurity.ui.rememberme;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;

/**
 * Another way to fix TokenBasedRememberMeServices's NullPointerException. 
 * By override logout() method. But configuration files need modified.
 * 
 * @author Xuefeng
 */
public class MyTokenBasedRememberMeServices
        extends TokenBasedRememberMeServices
{
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) {
        response.addCookie(makeCancelCookie(request));
    }
}
