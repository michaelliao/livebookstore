package net.livebookstore.util;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import net.livebookstore.domain.Book;

import org.junit.Test;

public class CookieUtilTest {

    static final String id = "923a890c2309128e9f0c18b2ae230d54";
    static final String name = "spring 2.0: web development中文";
    static final float price = 55.0f;
    static final int discount = 90;

    @Test
    public void book2Cookie() throws UnsupportedEncodingException {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setPrice(price);
        book.setDiscount(discount);
        Cookie cookie = CookieUtil.book2Cookie(book);
        assertEquals("BC#" + id, cookie.getName());
        assertEquals(price + "|" + discount + "|" + URLEncoder.encode(name, "UTF-8"), cookie.getValue());
        assertEquals("/cart", cookie.getPath());
    }

    @Test
    public void validCookie2Book() {
        Cookie cookie = new Cookie("BC#" + id, price + "|" + discount + "|" + name);
        cookie.setPath("/cart");
        Book book = CookieUtil.cookie2Book(cookie);
        assertEquals(id, book.getId());
        assertEquals(name, book.getName());
        assertEquals(price, book.getPrice());
        assertEquals(discount, book.getDiscount());
    }

    @Test
    public void invalidCookie2Book() throws UnsupportedEncodingException {
        Cookie cookie = new Cookie("#" + id, price + "|" + discount + "|" + URLEncoder.encode(name, "UTF-8"));
        assertNull(CookieUtil.cookie2Book(cookie));
        Cookie cookie2 = new Cookie("BC#" + id, price + "|" + URLEncoder.encode(name, "UTF-8"));
        assertNull(CookieUtil.cookie2Book(cookie2));
    }

}
