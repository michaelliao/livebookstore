package net.livebookstore.web.user;

import java.util.*;

import javax.servlet.http.*;

import net.livebookstore.domain.*;

import net.livebookstore.security.SecurityUtil;
import net.livebookstore.util.HttpUtil;
import net.livebookstore.web.core.*;
import net.livebookstore.web.filter.FileCacheFilter;

/**
 * Make a comment on a book.
 * 
 * @author xuefeng
 * 
 * @spring.bean name="/userMakeComment.jspx"
 */
public class MakeCommentController extends AbstractRedirectController {

    private boolean removeCache;
    private FileCacheFilter fileCacheFilter;

    /**
     * @spring.property value="true"
     */
    public void setRemoveCache(boolean removeCache) {
        this.removeCache = removeCache;
    }

    /**
     * @spring.property ref="fileCacheFilter"
     */
    public void setFileCacheFilter(FileCacheFilter fileCacheFilter) {
        this.fileCacheFilter = fileCacheFilter;
    }

    @Override
    public String redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bookId = HttpUtil.getString(request, "bookId");
        Book book = (Book) businessService.query(Book.class, bookId);
        Account me = (Account) businessService.query(Account.class, SecurityUtil.getCurrentUsername());
        // create comment:
        Comment comment = (Comment)HttpUtil.createFormBean(request, Comment.class);
        comment.setBook(book);
        comment.setAccount(me);
        comment.setCreatedDate(new Date());
        businessService.createComment(comment);
        // when comment is made, bookDetail cached page should be removed:
        if(removeCache) {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("id", bookId);
            fileCacheFilter.remove("/bookDetail.jspx", parameters);
        }
        return "bookDetail.jspx?id=" + bookId;
    }

}
