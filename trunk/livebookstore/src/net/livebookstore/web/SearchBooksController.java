package net.livebookstore.web;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.Book;
import net.livebookstore.domain.Page;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * Do a keyword search.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/searchBooks.jspx"
 */
public class SearchBooksController extends AbstractMvcController {

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        String q = HttpUtil.getString(request, "q", "");
        Page page = new Page(pageIndex);
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

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/search.htm";
    }

}
