package net.livebookstore.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.Order;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractRedirectController;

/**
 * Update order's state by administrator.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/adminManageOrder.jspx"
 */
public class AdminManageOrderController extends AbstractRedirectController {

    @Override
    protected String redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action");
        String id = HttpUtil.getString(request, "id");
        Order order = (Order)businessService.query(Order.class, id);
        if(action.equals("done"))
            businessService.updateOrder(order, Order.STATE_COMPLETE);
        if(action.equals("cancel"))
            businessService.updateOrder(order, Order.STATE_CANCELLED);
        return "adminListOrders.jspx";
    }

}
