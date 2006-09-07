package com.crackj2ee.bookstore.web;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.*;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.cache.FileCache;
import com.crackj2ee.bookstore.web.core.*;

/**
 * View a book's detail.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="bookDetailController" name="/bookDetail.jspx"
 */
public class BookDetailController extends AbstractMvcController implements FileCache {

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = HttpUtil.getString(request, "id");
        Book book = (Book)businessService.query(Book.class, id);
        Integer categoryId = new Integer(book.getCategoryId());
        Category root = businessService.queryRoot();
        Category current = (Category)businessService.query(Category.class, categoryId);
        List<Category> positions = new ArrayList<Category>(4);
        positions.add(current);
        int parentId = 0;
        while((parentId=current.getParentId())!=0) {
            Category p = (Category)businessService.query(Category.class, new Integer(parentId));
            positions.add(0, p);
            current = p;
        }
        // build model:
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("book", book);
        map.put("root", root);
        map.put("categoryId", new Integer(categoryId));
        map.put("positions", positions);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/bookDetail.html";
    }

    public String getCacheKey(HttpServletRequest request) {
        return "bk_" + HttpUtil.getString(request, "id");
    }

}
