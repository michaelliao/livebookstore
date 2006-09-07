package com.crackj2ee.bookstore.web;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.Category;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.cache.MemoryCache;
import com.crackj2ee.bookstore.web.core.*;

/**
 * List top sales books.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="topSalesController" name="/topSales.jspx"
 */
public class TopSalesController extends AbstractMvcController implements MemoryCache {

    private static final int DEFAULT_CACHE_TIME = 600; // 10 min
    private static final int TOP_MAX = 20;

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int categoryId = HttpUtil.getInt(request, "categoryId", Category.ROOT_ID);
        Category current = (Category) businessService.query(Category.class, new Integer(categoryId));
        Category root = businessService.queryRoot();
        List books = businessService.queryTopSales(current, TOP_MAX);
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
        map.put("root", root);
        map.put("categoryId", new Integer(categoryId));
        map.put("positions", positions);
        map.put("books", books);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/topSales.html";
    }

    public String getCacheKey(HttpServletRequest request) {
        int categoryId = HttpUtil.getInt(request, "categoryId", Category.ROOT_ID);
        return "topSale_" + categoryId;
    }

    public int getCacheTime() {
        return DEFAULT_CACHE_TIME;
    }

}
