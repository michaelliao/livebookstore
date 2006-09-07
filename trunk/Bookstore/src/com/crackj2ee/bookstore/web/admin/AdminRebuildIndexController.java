package com.crackj2ee.bookstore.web.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crackj2ee.bookstore.domain.*;
import com.crackj2ee.bookstore.web.core.AbstractMvcController;
import com.crackj2ee.bookstore.web.core.AdminRequired;

/**
 * Rebuild index for all books.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="adminRebuildIndexController" name="/adminRebuildIndex.jspx"
 */
public class AdminRebuildIndexController extends AbstractMvcController implements AdminRequired {

    @Override
    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("正在重建索引...");
        writer.flush();
        int total = 0;
        try {
            Category root = businessService.queryRoot();
            // get total pages:
            Page page = new Page(1);
            List<Book> list = businessService.queryBooks(root, page);
            total = page.getTotalCount();
            int pages = page.getPageCount();
            log.info("Total " + total + " books need to be indexed.");
            if(total>0) {
                // index page 1:
                log.info("Index page 1...");
                index_list_of_books(list);
                write_dot(writer);
                for(int i=2; i<=pages; i++) {
                    // index page i:
                    log.info("Index page " + i + "...");
                    List<Book> books = businessService.queryBooks(root, new Page(i));
                    index_list_of_books(books);
                    write_dot(writer);
                }
            }
            writer.write("<br>完成！一共有" + total + "本书籍被索引。请关闭窗口！");
        }
        catch(Exception e) {
            writer.write("<br>错误：" + e.getMessage());
            writer.write("<br><pre>");
            e.printStackTrace(writer);
            writer.write("</pre>");
        }
        writer.flush();
        return null;
    }

    private void write_dot(PrintWriter writer) throws IOException {
        writer.write(".");
        writer.flush();
    }

    private void index_list_of_books(List<Book> books) {
        for(Book book : books)
            index_one_book(book);
    }

    private void index_one_book(Book book) {
        searchService.index(book);
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
