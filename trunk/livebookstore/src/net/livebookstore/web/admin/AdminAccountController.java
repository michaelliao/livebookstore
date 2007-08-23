package net.livebookstore.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.Account;
import net.livebookstore.domain.Page;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * List all accounts.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/adminAccount.jspx"
 */
public class AdminAccountController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        Page page = new Page(pageIndex);
        List<Account> accounts = businessService.queryAccounts(page, false);
        Map model = new HashMap();
        model.put("accounts", accounts);
        model.put("page", page);
        return model;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/adminAccount.htm";
    }

}
