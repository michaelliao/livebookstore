package net.livebookstore.web.admin;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.domain.Account;
import net.livebookstore.domain.Page;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.AbstractMvcController;

/**
 * Broadcast mail to all users.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/adminBroadcast.jspx"
 */
public class AdminBroadcastMailController extends AbstractMvcController {

    @Override
    public Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final String subject = HttpUtil.getString(request, "subject", "Live在线书店");
        final String text = HttpUtil.getString(request, "text");
        // get total pages:
        Page firstPage = new Page(1);
        businessService.queryAccounts(firstPage, true);
        final int pageCount = firstPage.getPageCount();
        new Thread() {
            public void run() {
                for(int i=1; i<=pageCount; i++) {
                    List<Account> accounts = businessService.queryAccounts(new Page(i), true);
                    mailService.sendBroadcastMail(accounts, subject, text);
                }
            }
        }.start();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("<html><head><title>提示</title></head><body>系统已经开始在后台向<b>");
        writer.write(String.valueOf(firstPage.getTotalCount()));
        writer.write("</b>个用户发送邮件，请<a href='javascript:void(0)' onclick='window.close()'>关闭此窗口</a>！</body>");
        return null;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
