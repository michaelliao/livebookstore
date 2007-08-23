package net.livebookstore.web;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.Category;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.*;

/**
 * List top sales books.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/topSales.jspx"
 */
public class TopSalesController extends AbstractMvcController {

    private static final int TOP_MAX = 20;

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int categoryId = HttpUtil.getInt(request, "categoryId", Category.ROOT_ID);
        log.info("Current category id = " + categoryId);
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
        return "/topSales.htm";
    }

}
