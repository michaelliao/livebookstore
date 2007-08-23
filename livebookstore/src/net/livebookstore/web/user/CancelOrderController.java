package net.livebookstore.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.Order;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractRedirectController;

/**
 * Cancel this order.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/userCancelOrder.jspx"
 */
public class CancelOrderController extends AbstractRedirectController {

    @Override
    protected String redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = HttpUtil.getString(request, "id");
        Order order = (Order) businessService.query(Order.class, id);
        if(order.canCancel()) {
            businessService.cancelOrder(order);
        }
        return "userListOrders.jspx";
    }

}
