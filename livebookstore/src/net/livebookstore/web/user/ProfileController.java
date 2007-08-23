package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.InvalidStateException;
import org.hibernate.validator.InvalidValue;

import net.livebookstore.domain.Account;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * Edit user's profile.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/userProfile.jspx"
 */
public class ProfileController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String message = "";
        Account account = (Account) businessService.query(Account.class, SecurityUtil.getCurrentUsername());
        if(request.getMethod().equals("POST")) {
            // update:
            Account post = (Account) HttpUtil.createFormBean(request, Account.class);
            account.setEmail(post.getEmail());
            account.setName(post.getName());
            account.setAddress(post.getAddress());
            account.setZip(post.getZip());
            account.setTelephone(post.getTelephone());
            account.setMobile(post.getMobile());
            try {
                businessService.updateAccount(account);
                message = "更新成功！";
            }
            catch(InvalidStateException e) {
                StringBuffer sb = new StringBuffer(128);
                InvalidValue[] ivs = e.getInvalidValues();
                for(InvalidValue iv : ivs)
                    sb.append(iv.getMessage()).append("<br/>");
                message = sb.toString();
            }
        }
        Map map = new HashMap();
        map.put("account", account);
        map.put("message", message);
        return map;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/profile.htm";
    }

}
