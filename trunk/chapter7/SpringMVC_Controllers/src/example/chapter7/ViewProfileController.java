package example.chapter7;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 可以处理多个动作的MultiActionController
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/*Profile.do"
 * 
 * 如果要使用ParameterMethodNameResolver,将Bean name设置为"/profile.do",加下列注释:
 * spring.property name="methodNameResolver" ref="methodNameResolver"
 * URL: /profile.do?action=basicProfile
 */
public class ViewProfileController extends MultiActionController {

    private UserService userService;

    /**
     * @spring.property ref="userService"
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String getUsername(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("USERNAME");
        if(username==null)
            throw new NeedLoginException();
        return username;
    }

    public ModelAndView basicProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getUsername(request);
        User user = userService.query(username);
        Map model = new HashMap();
        model.put("username", user.getUsername());
        return new ModelAndView("basicProfile", model);
    }

    public ModelAndView contactProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getUsername(request);
        User user = userService.query(username);
        Map model = new HashMap();
        model.put("email", user.getEmail());
        model.put("blog", user.getBlog());
        model.put("website", user.getWebsite());
        return new ModelAndView("contactProfile", model);
    }

    public ModelAndView addressProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getUsername(request);
        User user = userService.query(username);
        Map model = new HashMap();
        model.put("province", user.getProvince());
        model.put("city", user.getCity());
        model.put("zip", user.getZip());
        return new ModelAndView("addressProfile", model);
    }

}
