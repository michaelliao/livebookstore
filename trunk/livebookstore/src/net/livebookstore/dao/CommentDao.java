package net.livebookstore.dao;

import java.util.List;

import net.livebookstore.domain.Book;
import net.livebookstore.domain.Comment;
import net.livebookstore.domain.Page;

/**
 * Define Comment operations.
 * 
 * @author Xuefeng
 */
public interface CommentDao extends GenericDao<Comment> {

    List<Comment> queryComments(Book book, Page page);

    void deleteComments(Book book);
}
