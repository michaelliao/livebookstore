package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.*;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.*;

/**
 * Display orders in MyLive main page.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/userListOrders.jspx"
 */
public class ListOrdersController extends AbstractMvcController {

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // list all orders:
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        Page page = new Page(pageIndex, 10);
        Account account = (Account) businessService.query(Account.class, SecurityUtil.getCurrentUsername());
        List<Order> orders = businessService.queryOrders(account, page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("orders", orders);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/listOrders.htm";
    }

}
