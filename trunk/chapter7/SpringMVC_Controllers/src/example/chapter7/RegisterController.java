package example.chapter7;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

/**
 * A register wizard controller.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/register.do"
 * @spring.property name="commandClass" value="example.chapter7.User"
 * @spring.property name="pages" list="registerStep0,registerStep1,registerStep2"
 */
public class RegisterController extends AbstractWizardFormController {

    private UserService userService;

    /**
     * @spring.property ref="userService"
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    // 当用户点击"_finish"按钮时,触发processFinish()方法:
    protected ModelAndView processFinish(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        User user = (User)command;
        userService.register(user);
        Map model = new HashMap();
        model.put("username", user.getUsername());
        return new ModelAndView("registerSuccess", model);
    }

    @Override
    // 每当用户点击"_target?"准备前进到下一步时,触发validatePage()来验证当前页:
    protected void validatePage(Object command, Errors errors, int page) {
        User user = (User)command;
        if(page==0) {
            // 验证username,password:
            if(!user.getUsername().matches("[a-zA-Z0-9]{3,20}"))
                errors.rejectValue("username", "error.username", "用户名不符合要求");
            if(userService.isExist(user.getUsername()))
                errors.rejectValue("username", "error.username", "用户名已存在");
            if(user.getPassword()==null || user.getPassword().length()<6)
                errors.rejectValue("password", "error.password", "口令至少为6个字符");
        }
        else if(page==1) {
            // 验证email,blog,website:
            if(user.getEmail()==null)
                errors.rejectValue("email", "error.email.empty", "电子邮件不能为空");
            else if(!user.getEmail().matches("[a-zA-Z0-9\\_\\-]+\\@[a-zA-Z0-9\\_\\-\\.]+"))
                errors.rejectValue("email", "error.email", "电子邮件地址无效");
            if(user.getBlog()==null || user.getBlog().trim().equals(""))
                errors.rejectValue("blog", "error.blog", "博客地址不能为空");
            if(user.getWebsite()==null || user.getWebsite().trim().equals(""))
                errors.rejectValue("website", "error.website", "网址地址不能为空");
        }
        else if(page==2) {
            // 验证province,city,zip:
        }
    }

}
