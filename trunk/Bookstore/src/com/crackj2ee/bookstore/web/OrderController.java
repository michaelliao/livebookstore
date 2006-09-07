package com.crackj2ee.bookstore.web;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.*;

/**
 * Handle user's order.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="orderController" name="/order.jspx"
 */
public class OrderController extends AbstractMvcController implements LoginRequired {

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action", "list");
        if(action.equals("confirm")) {
            // confirm this order:
            //messageSender(new Mail("asklxf@163.com", "A test for jms", "hello, this is your order..."));
            response.getWriter().write("Message sent!");
        }
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/order.html";
    }

}
