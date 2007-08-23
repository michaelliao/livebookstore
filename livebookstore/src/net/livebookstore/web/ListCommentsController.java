package net.livebookstore.web;

import java.util.*;
import javax.servlet.http.*;

import net.livebookstore.domain.*;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * List comments by specified book.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/listComments.jspx"
 */
public class ListCommentsController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = HttpUtil.getString(request, "id");
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        Book book = (Book)businessService.query(Book.class, id);
        Category root = businessService.queryRoot();
        Page page = new Page(pageIndex);
        List comments = businessService.queryComments(book, page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("root", root);
        map.put("book", book);
        map.put("comments", comments);
        return map;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/listComments.htm";
    }

}
