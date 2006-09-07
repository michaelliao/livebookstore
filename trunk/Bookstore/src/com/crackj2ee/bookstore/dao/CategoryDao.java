package com.crackj2ee.bookstore.dao;

import com.crackj2ee.bookstore.domain.*;

/**
 * Define Category operations.
 * 
 * @author xuefeng
 */
public interface CategoryDao extends GenericDaoSupport<Category> {

    /**
     * Query for root category.
     * 
     * @return Root category.
     */
    Category queryRoot();

    /**
     * Create a category under specified category.
     * 
     * @param c Category object to create.
     * @param parentId Parent category id.
     */
    void create(Category c, Integer parentId);

}
