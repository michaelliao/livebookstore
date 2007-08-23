package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.*;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * List user's favorite books.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/userFavorite.jspx"
 */
public class FavoriteController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action", "list");
        Account account = (Account) businessService.query(Account.class, SecurityUtil.getCurrentUsername());
        if(action.equals("add")) {
            // add new favorite book:
            String id = HttpUtil.getString(request, "id");
            Book book = (Book) businessService.query(Book.class, id);
            businessService.createFavorite(account, book);
        }
        else if(action.equals("remove")) {
            // remove favorite book:
            String id = HttpUtil.getString(request, "id");
            Book book = (Book) businessService.query(Book.class, id);
            businessService.deleteFavorite(account, book);
        }
        // list:
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        Page page = new Page(pageIndex, 20);
        List books = businessService.queryFavorite(account, page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("books", books);
        map.put("page", page);
        return map;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/favorite.htm";
    }

}
