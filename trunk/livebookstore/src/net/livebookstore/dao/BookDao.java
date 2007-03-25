package net.livebookstore.dao;

import java.util.List;

import net.livebookstore.domain.*;

/**
 * Define Book operations.
 * 
 * @author xuefeng
 */
public interface BookDao extends GenericDao<Book> {

    /**
     * Query books by specified category.
     * 
     * @param c Category object.
     * @param page Page info.
     * @return List of books.
     */
    List<Book> query(Category c, Page page);

    /**
     * Query top sales  by specified category.
     * 
     * @param c Category object.
     * @param max Top ?.
     * @return List of books.
     */
    List<Book> queryTopSales(Category c, int max);

    /**
     * Query favorite books.
     * @param account Account object.
     * @param page Page info.
     * @return List of books.
     */
    List<Book> queryFavorite(Account account, Page page);

    /**
     * Add a new favorite book.
     * 
     * @param account Account object.
     * @param book Book object.
     * @return True if added successfully, false if already added.
     */
    boolean createFavorite(Account account, Book book);

    /**
     * Delete a favorite book.
     * 
     * @param account Account object.
     * @param book Book object.
     */
    void deleteFavorite(Account account, Book book);

    /**
     * Update book's sold count.
     */
    void updateSold(Book book, int sold);

}
