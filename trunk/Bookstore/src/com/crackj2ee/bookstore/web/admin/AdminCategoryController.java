package com.crackj2ee.bookstore.web.admin;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.*;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.*;

/**
 * Manage category.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="adminCategoryController" name="/adminCategory.jspx"
 */
public class AdminCategoryController extends AbstractMvcController implements AdminRequired {

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action", "");
        if(action.equals("create")) {
            int parentId = HttpUtil.getInt(request, "parentId");
            Category category = (Category) HttpUtil.createFormBean(request, Category.class);
            businessService.create(category, new Integer(parentId));
            response.sendRedirect("adminCategory.jspx");
        }
        else if(action.equals("delete")) {
            Category category = (Category) HttpUtil.createFormBean(request, Category.class);
            businessService.delete(category);
            response.sendRedirect("adminCategory.jspx");
        }
        else if(action.equals("update")) {
            Category category = (Category) HttpUtil.createFormBean(request, Category.class);
            businessService.update(category);
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
        return "/adminCategory.html";
    }

}
