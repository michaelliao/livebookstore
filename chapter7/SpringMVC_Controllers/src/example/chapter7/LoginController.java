package example.chapter7;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 处理用户登录表单
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/login.do"
 * @spring.property name="commandClass" value="example.chapter7.User"
 * @spring.property name="formView" value="login"
 * @spring.property name="successView" value="loginSuccess"
 * @spring.property name="validator" ref="loginValidator"
 */
public class LoginController extends SimpleFormController {

    private UserService userService;

    /**
     * @spring.property ref="userService"
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        User user = (User)command;
        try {
            userService.login(user.getUsername(), user.getPassword());
            // 登录成功，在Session中标记:
            request.getSession().setAttribute("USERNAME", user.getUsername());
            // 然后返回successView:
            Map model = new HashMap();
            model.put("username", user.getUsername());
            return new ModelAndView(getSuccessView(), model);
        }
        catch(RuntimeException e) {
            // 登录失败,返回formView让用户重新填写表单:
            Map model = new HashMap();
            model.put("command", command);
            model.put("error", e.getMessage());
            return new ModelAndView(getFormView(), model);
        }
    }

}
