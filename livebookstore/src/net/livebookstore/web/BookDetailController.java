package net.livebookstore.web;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.*;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.*;

/**
 * View a book's detail.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/bookDetail.jspx"
 */
public class BookDetailController extends AbstractMvcController {

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        Page page = new Page(1);
        List comments = businessService.queryComments(book, page);
        // build model:
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("book", book);
        map.put("root", root);
        map.put("categoryId", new Integer(categoryId));
        map.put("positions", positions);
        map.put("commentCount", new Integer(page.getTotalCount()));
        map.put("comments", comments);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/bookDetail.htm";
    }

}
