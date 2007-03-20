package net.livebookstore.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import net.livebookstore.domain.Book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * CookieUtil to simplify cookie operation.
 * 
 * @author Xuefeng
 */
public class CookieUtil {

    private static final int MAX_AGE = (-1); // session scope!
    private static final String PATH = "/cart";
    private static final String BOOK_COOKIE = "BC#";

    private static Log log = LogFactory.getLog(CookieUtil.class);

    /**
     * Return a book cookie to delete immediately.
     * 
     * @param bookId Book's id.
     */
    public static Cookie deleteBookCookie(String bookId) {
        String name = BOOK_COOKIE + bookId;
        Cookie cookie = new Cookie(name, "any");
        cookie.setMaxAge(0);
        cookie.setPath(PATH);
        return cookie;
    }

    public static Cookie book2Cookie(Book book) {
        String name = BOOK_COOKIE + book.getId();
        String value = book.getPrice() + "|"
                     + book.getDiscount() + "|"
                     + encode(book.getName());
        log.info("[book2cookie] name: " + name);
        log.info("[book2cookie] value: " + value);
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(MAX_AGE);
        cookie.setPath(PATH);
        return cookie;
    }

    public static Book cookie2Book(Cookie cookie) {
        String name = cookie.getName();
        try {
            if(name.startsWith(BOOK_COOKIE)) {
                String id = name.substring(BOOK_COOKIE.length());
                String value = cookie.getValue();
                log.info("[cookie2book] name: " + name);
                log.info("[cookie2book] value: " + value);
                String[] bk = value.split("\\|", 3);
                if(bk.length==3) {
                    Book book = new Book();
                    book.setId(id);
                    book.setPrice(Float.parseFloat(bk[0]));
                    book.setDiscount(Integer.parseInt(bk[1]));
                    book.setName(decode(bk[2]));
                    return book;
                }
            }
        }
        catch(Exception e) {}
        return null;
    }

    private static String encode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String decode(String s) throws UnsupportedEncodingException {
        return URLDecoder.decode(s, "UTF-8");
    }
}
