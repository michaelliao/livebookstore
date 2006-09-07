package com.crackj2ee.bookstore.dao;

import java.util.List;

import com.crackj2ee.bookstore.domain.*;

/**
 * Define book operations.
 * 
 * @author xuefeng
 */
public interface BookDao extends GenericDaoSupport<Book> {

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

}
