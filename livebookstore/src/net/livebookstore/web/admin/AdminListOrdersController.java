package net.livebookstore.web.admin;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.*;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * List all orders for administrative.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/adminListOrders.jspx"
 */
public class AdminListOrdersController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        Page page = new Page(pageIndex, 20);
        List<Order> orders = businessService.queryOrders(page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orders", orders);
        map.put("page", page);
        return map;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/adminListOrders.htm";
    }

}
