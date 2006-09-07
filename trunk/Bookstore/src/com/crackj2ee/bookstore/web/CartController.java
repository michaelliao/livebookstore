package com.crackj2ee.bookstore.web;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.Book;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.*;

/**
 * View cart information. Because cart is stored in cookies, so do not need login.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="cartController" name="/cart.jspx"
 */
public class CartController extends AbstractMvcController {

    private static final int MAX_BOOKS = 15;
    private static final String BOOK_COOKIE_PREFIX = "Book";

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action", "list");
        if(action.equals("list")) {
            // list cart's books:
            List<Book> books = cookies2Books(request.getCookies());
            removeOldestBooks(response, books, MAX_BOOKS);
            return buildMap(books);
        }
        else if(action.equals("add")) {
            // add new book to cart:
            String bookName = HttpUtil.getString(request, "name");
            float bookPrice = HttpUtil.getFloat(request, "price");
            Book book = new Book();
            book.setName(bookName);
            book.setPrice(bookPrice);
            // get current books:
            List<Book> books = cookies2Books(request.getCookies());
            removeOldestBooks(response, books, MAX_BOOKS-1);
            // add new book:
            response.addCookie(addCookie(book));
            books.add(0, book);
            return buildMap(books);
        }
        else if(action.equals("remove")) {
            // remove book from cart:
            String bookId = HttpUtil.getString(request, "id");
            // get current books:
            List<Book> books = cookies2Books(request.getCookies());
            removeOldestBooks(response, books, MAX_BOOKS);
            // remove specified book:
            Iterator<Book> it = books.iterator();
            while(it.hasNext()) {
                Book book = it.next();
                if(book.getId().equals(bookId)) {
                    response.addCookie(removeCookie(book));
                    it.remove();
                }
            }
            return buildMap(books);
        }
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/cart.html";
    }

    private Map buildMap(List<Book> books) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("books", books);
        return map;
    }

    private void removeOldestBooks(HttpServletResponse response, List<Book> allBooks, int maxReserved) {
        while(allBooks.size()>maxReserved) {
            Book book = allBooks.remove(allBooks.size()-1);
            response.addCookie(removeCookie(book));
        }
    }

    private Cookie addCookie(Book book) {
        return _get(book.getId(), book.getName(), book.getPrice(), Integer.MAX_VALUE);
    }

    private Cookie removeCookie(Book book) {
        return _get(book.getId(), book.getName(), book.getPrice(), 0);
    }

    private Cookie _get(String bookId, String bookName, float bookPrice, int age) {
        Cookie c = new Cookie(BOOK_COOKIE_PREFIX + bookId, System.currentTimeMillis() + "_" + bookPrice + "_" + bookName);
        c.setPath("/");
        c.setMaxAge(age);
        return c;
    }

    private List<Book> cookies2Books(Cookie[] cookies) {
        Map<Integer, Book> map = new HashMap<Integer, Book>();
        for(Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if(!cookieName.startsWith(BOOK_COOKIE_PREFIX))
                continue;
            String cookieValue = cookie.getValue();
            if(cookieValue==null)
                continue;
            cookieValue = cookieValue.trim();
            if("".equals(cookieValue))
                continue;
            String[] splits = cookieValue.split("\\_", 3);
            if(splits.length!=3)
                continue;
            try {
                String bookId = cookieName.substring(BOOK_COOKIE_PREFIX.length());
                int order = Integer.parseInt(splits[0]);
                float bookPrice = Float.parseFloat(splits[1]);
                String bookName = splits[2].trim();
                if(bookName.equals(""))
                    continue;
                Book book = new Book();
                book.setId(bookId);
                book.setName(bookName);
                book.setPrice(bookPrice);
                map.put(new Integer(order), book);
            }
            catch(Exception e) {
                /* Maybe NumberFormatException, ignore it */
            }
        }
        // sort books by time, desc:
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys, Collections.reverseOrder());
        List<Book> books = new ArrayList<Book>(keys.length);
        for(Integer key : keys)
            books.add(map.get(key));
        return books;
    }
}
