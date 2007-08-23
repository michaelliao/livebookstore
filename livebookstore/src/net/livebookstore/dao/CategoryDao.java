package net.livebookstore.dao;

import net.livebookstore.domain.*;

/**
 * Define Category operations.
 * 
 * @author xuefeng
 */
public interface CategoryDao extends GenericDao<Category> {

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
