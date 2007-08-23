package net.livebookstore.web.admin;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.*;

import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.*;

/**
 * Manage category.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/adminCategory.jspx"
 */
public class AdminCategoryController extends AbstractMvcController {

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action", "");
        if(action.equals("create")) {
            int parentId = HttpUtil.getInt(request, "parentId");
            Category category = (Category) HttpUtil.createFormBean(request, Category.class);
            businessService.createCategory(category, new Integer(parentId));
            response.sendRedirect("adminCategory.jspx");
        }
        else if(action.equals("delete")) {
            Category category = (Category) HttpUtil.createFormBean(request, Category.class);
            businessService.delete(category);
            response.sendRedirect("adminCategory.jspx");
        }
        else if(action.equals("update")) {
            Category category = (Category) HttpUtil.createFormBean(request, Category.class);
            businessService.updateCategory(category);
            response.sendRedirect("adminCategory.jspx");
        }
        else {
            Map map = new HashMap();
            map.put("root", businessService.queryRoot());
            return map;
        }
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/adminCategory.htm";
    }

}
