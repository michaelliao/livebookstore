package com.crackj2ee.bookstore.web;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.*;

/**
 * Check user state.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="checkStateController" name="/checkState.jspx"
 */
public class CheckStateController extends AbstractScriptController {

    private static final String NOT_LOGIN = "var login=false;\n"
            + "document.write(\"[ <a href='' onClick='goLogin(this)'>登录</a> <a href='reg.html' target='_blank'>新用户注册</a> ]\");\n";

    public String getScript(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Identity identity = HttpUtil.getIdentity();
        if(identity!=null)
            return "var login=true;\ndocument.write(\"[ 欢迎" + identity.getUsername() + "！ <a href='myLive.jspx'>我的Live</a> <a href='' onClick='goLogout(this)'>登出</a> ]\");\n";
        return NOT_LOGIN;
    }

    public int getCacheTime(HttpServletRequest request, HttpServletResponse response) {
        return 0;
    }

}
