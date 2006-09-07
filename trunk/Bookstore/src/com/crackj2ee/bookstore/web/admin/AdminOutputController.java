package com.crackj2ee.bookstore.web.admin;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.Category;
import com.crackj2ee.bookstore.web.core.*;

/**
 * Output all categories as SQL script.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="adminOutputController" name="/adminOutput.jspx"
 */
public class AdminOutputController extends AbstractMvcController implements AdminRequired {

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Category root = businessService.queryRoot();
        response.setContentType("text/plain;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        output(pw, root);
        pw.flush();
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    private void output(PrintWriter pw, Category ca) {
        for(Category c : ca.getChildren()) {
            pw.println("INSERT INTO T_Category (id, name, categoryOrder) VALUES (" + c.getId() + ", '" + c.getName() + "', " + c.getCategoryOrder()  + ");");
            output(pw, c);
        }
    }
}
