package net.livebookstore.business;

import java.util.List;

import net.livebookstore.domain.Book;
import net.livebookstore.domain.Page;

/**
 * Search and index books.
 * 
 * @author xuefeng
 */
public interface SearchService {

    /**
     * Do a full-text search.
     * 
     * @param q Keyword to search.
     * @param page Page info.
     * @return List of Book object.
     */
    List<Book> search(String q, Page page);

    /**
     * Make this book to searchable.
     */
    void index(Book book);

    /**
     * Make this book to unsearchable. NOTE: only book's id is needed, 
     * other fields can leave as null for faster serialize.
     */
    void unindex(Book book);

    /**
     * Reindex this book if book has been changed.
     */
    void reindex(Book book);

}
