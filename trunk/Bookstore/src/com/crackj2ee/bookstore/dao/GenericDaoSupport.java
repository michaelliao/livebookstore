package com.crackj2ee.bookstore.dao;

import java.io.Serializable;

/**
 * Define some generate operations.
 * 
 * @author xuefeng
 * 
 * @param <T> Domain type.
 */
public interface GenericDaoSupport<T> {

    /**
     * Query object by specified id.
     */
    T query(Serializable id);

    /**
     * Create an domain object.
     */
    void create(T t);

    /**
     * Delete an object.
     */
    void delete(T t);

    /**
     * Update an object.
     */
    void update(T t);

}
