package com.crackj2ee.bookstore.web;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crackj2ee.bookstore.domain.Account;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.AbstractMvcController;

/**
 * Do user register.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="registerController" name="/register.jspx"
 */
public class RegisterController extends AbstractMvcController {

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Account account = (Account) HttpUtil.createFormBean(request, Account.class);
        account.setPrivilege(Account.PRIVILEGE_USER);
        account.setCreatedDate(new Date());
        businessService.create(account);
        mailService.sendRegistrationMail(account);
        response.sendRedirect("regOK.html");
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
