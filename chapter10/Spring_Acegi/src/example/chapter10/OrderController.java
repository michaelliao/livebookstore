package example.chapter10;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class OrderController implements Controller {

    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        service.createOrder("order_id");
        PrintWriter writer = response.getWriter();
        writer.write("<h3>createOrder() called.</h3>");
        return null;
    }

}
