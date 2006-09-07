package com.crackj2ee.bookstore.business;

import java.io.Serializable;
import java.util.List;

import com.crackj2ee.bookstore.domain.*;

/**
 * Core service interface for business logic. All data access operations 
 * like DAO are behind this service. Also this is the facade interactive 
 * with all controllers.
 * 
 * @author xuefeng
 */
public interface BusinessService {

    Object query(Class clazz, Serializable id);

    void create(Object object);

    void create(Category category, Integer parentId);

    void update(Object object);

    void delete(Object object);

    Account login(String username, String password);

    Category queryRoot();

    List queryBooks(Category c, Page page);

    List queryTopSales(Category c, int max);

}
