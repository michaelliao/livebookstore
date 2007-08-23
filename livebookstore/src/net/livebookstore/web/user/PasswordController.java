package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * Change user's password.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/userPassword.jspx"
 */
public class PasswordController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String message = "";
        String username = SecurityUtil.getCurrentUsername();
        if(request.getMethod().equals("POST")) {
            String oldPassword = HttpUtil.getString(request, "oldPassword");
            String newPassword = HttpUtil.getString(request, "newPassword");
            try {
                businessService.changePassword(username, oldPassword, newPassword);
                message = "口令已成功更改！";
            }
            catch(Exception e) {
                message = e.getMessage();
            }
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("message", message);
        return map;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/password.htm";
    }

}
