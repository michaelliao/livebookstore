package net.livebookstore.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;

import net.livebookstore.domain.Account;

import net.livebookstore.web.core.AbstractFormController;

/**
 * Register a new user.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/register.jspx"
 */
public class RegisterController extends AbstractFormController {

    private static final Account EMPTY_FORM = new Account();

    protected Object getEmptyFormObject() {
        return EMPTY_FORM;
    }

    protected void doSubmit(Object obj) {
        Account account = (Account) obj;
        account.setPrivilege(Account.PRIVILEGE_USER);
        account.setCreatedDate(new Date());
        businessService.createAccount(account);
        mailService.sendRegistrationMail(account);
    }

    protected String getFormView(HttpServletRequest request) {
        return "/reg.html";
    }

    protected String getSuccessView(HttpServletRequest request) {
        return "/regOK.html";
    }

    protected String convertException(Exception e) {
        if(e instanceof DataIntegrityViolationException)
            return "指定的用户名已存在";
        return null;
    }

    @Override
    protected void validate(List<String> errors, Object form) {
    }

}
