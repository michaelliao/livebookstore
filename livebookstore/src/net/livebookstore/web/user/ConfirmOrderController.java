package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.*;

import net.livebookstore.exception.OrderException;
import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.CookieUtil;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * Confirm user's order.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/userConfirmOrder.jspx"
 */
public class ConfirmOrderController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // first check all books:
        String[] bookIds = request.getParameterValues("bookIds");
        String[] numbers = request.getParameterValues("bookNumbers");
        if(bookIds==null || numbers==null)
            throw new OrderException("错误参数");
        if(bookIds.length!=numbers.length)
            throw new OrderException("错误参数");
        List<OrderItem> items = new ArrayList<OrderItem>(10);
        for(int i=0; i<bookIds.length; i++) {
            int number = 1;
            try {
                number = Integer.parseInt(numbers[i]);
            }
            catch(Exception e) {}
            if(number<1)
                number = 1;
            if(number>10)
                number = 10;
            try {
                Book book = (Book) businessService.query(Book.class, bookIds[i]);
                OrderItem item = new OrderItem();
                item.setBook(book);
                item.setNumber(number);
                items.add(item);
            }
            catch(Exception e) {
                // maybe the cookie has been expired!
                response.addCookie(CookieUtil.deleteBookCookie(bookIds[i]));
            }
        }
        if(items.size()==0)
            throw new OrderException("没有选择任何书籍");
        Order order = (Order) HttpUtil.createFormBean(request, Order.class);
        Account account = (Account) businessService.query(Account.class, SecurityUtil.getCurrentUsername());
        order.setAccount(account);
        order.setCreatedDate(new Date());
        businessService.createOrder(order, items);
        mailService.sendOrderMail(order);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orderId", order.getId());
        return map;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/confirmOrder.htm";
    }

}
