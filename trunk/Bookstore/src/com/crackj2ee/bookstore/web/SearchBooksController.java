package com.crackj2ee.bookstore.web;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.Book;
import com.crackj2ee.bookstore.domain.Page;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.AbstractMvcController;

/**
 * Do a keyword search.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="searchBooksController" name="/searchBooks.jspx"
 */
public class SearchBooksController extends AbstractMvcController {

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Book book = (Book)HttpUtil.createFormBean(request, Book.class);
        String action = HttpUtil.getString(request, "action", "");
        if(action.equals("")) {
            // do a search:
            int pageIndex = HttpUtil.getInt(request, "page", 1);
            Page page = new Page(pageIndex, "search.jspx");
            String q = HttpUtil.getString(request, "q");
            long start_time = System.currentTimeMillis();
            List<Book> books = searchService.search(q, page);
            long cost_time = System.currentTimeMillis() - start_time;
            float cost = cost_time / 1000f;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("q", q);
            map.put("page", page);
            map.put("books", books);
            map.put("time", String.valueOf(cost));
            return map;
        }
        if(action.equals("index")) {
            searchService.index(book);
        }
        if(action.equals("unindex")) {
            searchService.unindex(book);
        }
        if(action.equals("reindex")) {
            searchService.reindex(book);
        }
        //messageSender.sendObjectMessage(book);
        response.getWriter().write(action + " done!");
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/search.html";
    }

}
