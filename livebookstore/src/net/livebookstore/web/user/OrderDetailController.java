package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.Order;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * View order's detail.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/userOrderDetail.jspx"
 */
public class OrderDetailController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = HttpUtil.getString(request, "id");
        Order order = (Order) businessService.query(Order.class, id);
        Map map = new HashMap();
        map.put("order", order);
        map.put("items", order.getOrderItems());
        return map;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/orderDetail.htm";
    }

}
