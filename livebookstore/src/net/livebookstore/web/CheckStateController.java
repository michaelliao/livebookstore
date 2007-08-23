package net.livebookstore.web;

import javax.servlet.http.*;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.web.core.*;

/**
 * Check user state.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/checkState.jspx"
 */
public class CheckStateController extends AbstractScriptController {

    private static final String NOT_LOGIN = "var login=false;\n"
            + "document.write(\"[ <a href='javascript:void(0)' onClick='goLogin(this)'>登录</a> <a href='register.jspx' target='_blank'>新用户注册</a> ]\");\n";

    public String getScript(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = SecurityUtil.getCurrentUsernameOrNull();
        if(username!=null)
            return "var login=true;\ndocument.write(\"[ 欢迎" + username + "！ <a href='userListOrders.jspx'>我的Live</a> <a href='' onClick='goLogout(this)'>登出</a> ]\");\n";
        return NOT_LOGIN;
    }

    public int getCacheTime(HttpServletRequest request, HttpServletResponse response) {
        return 0;
    }

}
