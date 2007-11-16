package example.chapter7;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("admin".equals(username) && "password".equals(password)) {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("username", username);
            model.put("greet", "Welcome!");
            model.put("time", new Date().toString());
            return new ModelAndView("/welcome.jsp", model);
        }
        Map<String, Object> error = new HashMap<String, Object>();
        error.put("message", "Login failed.");
        error.put("time", new Date().toString());
        return new ModelAndView("/loginFailed.jsp", error);
    }

}
