package net.livebookstore.web;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.Book;

import net.livebookstore.util.CookieUtil;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.*;

/**
 * View cart information. Because cart is stored in cookies, so do not need login.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/cart/cart.jspx"
 */
public class CartController extends AbstractMvcController {

    private static final int MAX_BOOKS = 20;

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action", "list");
        List<Book> books = new ArrayList<Book>(10);
        // get all cart's books:
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            Book book = CookieUtil.cookie2Book(cookie);
            if(book!=null)
                books.add(book);
        }
        if(action.equals("add")) {
            // first check if this book is already added to cart:
            String id = HttpUtil.getString(request, "id");
            boolean added = false;
            for(Book b : books) {
                if(b.getId().equals(id)) {
                    added = true;
                    break;
                }
            }
            if(!added) {
                while(books.size()>=MAX_BOOKS)
                    books.remove(0);
                Book book = (Book) businessService.query(Book.class, id);
                books.add(book);
                // add cookie:
                Cookie cookie = CookieUtil.book2Cookie(book);
                response.addCookie(cookie);
            }
        }
        else if(action.equals("remove")) {
            // remove book from cart:
            String id = HttpUtil.getString(request, "id");
            Book found = null;
            for(Book book : books) {
                if(book.getId().equals(id)) {
                    // found and remove it:
                    found = book;
                    books.remove(book);
                    break;
                }
            }
            if(found!=null) {
                // remove this book from cookie:
                Cookie cookie = CookieUtil.book2Cookie(found);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("books", books);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/cart/cart.htm";
    }

}
