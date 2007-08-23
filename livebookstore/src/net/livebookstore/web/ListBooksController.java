package net.livebookstore.web;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.*;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * List books by specified category.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/listBooks.jspx"
 */
public class ListBooksController extends AbstractMvcController {

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int categoryId = HttpUtil.getInt(request, "categoryId", Category.ROOT_ID);
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        Page page = new Page(pageIndex);
        Category root = businessService.queryRoot();
        Category current = (Category)businessService.query(Category.class, new Integer(categoryId));
        List books = businessService.queryBooks(current, page);
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
        map.put("page", page);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "listBooks.htm";
    }

}
