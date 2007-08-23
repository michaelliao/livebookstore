package net.livebookstore.web.admin;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.*;

import net.livebookstore.domain.Category;

import net.livebookstore.web.core.*;

/**
 * Output all categories as SQL script.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/adminOutput.jspx"
 */
public class AdminOutputController extends AbstractMvcController {

    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
            pw.println("INSERT INTO t_category (id, name, categoryOrder) VALUES (" + c.getId() + ", '" + toSqlString(c.getName()) + "', " + c.getCategoryOrder()  + ");");
            output(pw, c);
        }
    }

    private String toSqlString(String s) {
        return s.replaceAll("\\\'", "\\\'");
    }
}
