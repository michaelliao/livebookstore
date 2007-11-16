package example.chapter7;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String view = request.getParameter("view");
        if(view==null)
            view = "jsp";
        String name = request.getParameter("name");
        if(name==null)
            name = "spring";
        Map model = new HashMap();
        model.put("name", name);
        model.put("time", new Date());
        return new ModelAndView("/test." + view, model);
    }

}
