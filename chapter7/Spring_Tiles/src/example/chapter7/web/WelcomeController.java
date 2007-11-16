package example.chapter7.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 显示用户信息
 */
public class WelcomeController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return new ModelAndView("redirect:login");
        return new ModelAndView("welcome");
    }

}
