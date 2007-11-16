package example.chapter7;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        if(name==null)
            name = "world";
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", "This is a TestController.");
        model.put("greet", "Hello, " + name + "!");
        model.put("time", new Date().toString());
        return new ModelAndView("/test.jsp", model);
    }

}
