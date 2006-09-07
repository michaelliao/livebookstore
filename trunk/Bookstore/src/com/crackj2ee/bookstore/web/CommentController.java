package com.crackj2ee.bookstore.web;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.domain.*;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.web.core.*;

/**
 * Make a comment on a book.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="commentController" name="/comment.jspx"
 */
public class CommentController extends AbstractMvcController implements LoginRequired {

    @Override
    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Comment comment = (Comment)HttpUtil.createFormBean(request, Comment.class);
        String bookId = HttpUtil.getString(request, "bookId");
        Book book = (Book) businessService.query(Book.class, bookId);
        Account me = (Account) businessService.query(Account.class, HttpUtil.getIdentity().getUsername());
        comment.setBook(book);
        comment.setAccount(me);
        businessService.create(comment);
        response.sendRedirect("bookDetail.jspx?id=" + bookId);
        return null;
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
