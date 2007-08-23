package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.Account;
import net.livebookstore.domain.Book;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.CookieUtil;
import net.livebookstore.web.core.*;

/**
 * Preview user's order.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/cart/previewOrder.jspx"
 */
public class PreviewOrderController extends AbstractMvcController {

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Book> books = new ArrayList<Book>(10);
        // get all cart's books:
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            Book book = CookieUtil.cookie2Book(cookie);
            if(book!=null)
                books.add(book);
        }
        Account account = (Account) businessService.query(Account.class, SecurityUtil.getCurrentUsername());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("books", books);
        map.put("account", account);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/cart/previewOrder.htm";
    }

}
