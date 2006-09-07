package com.crackj2ee.bookstore.dao;

import java.util.List;

import com.crackj2ee.bookstore.domain.*;

/**
 * Define all order operations.
 * 
 * @author xuefeng
 */
public interface OrderDao extends GenericDaoSupport<Order> {

    /**
     * Create order object.
     * 
     * @param order Order object.
     * @param items OrderItem objects belong to this order.
     */
    void create(Order order, List<OrderItem> items);

    /**
     * Query orders belong to specified account.
     * 
     * @param account Account object.
     * @param page Page object.
     * @return List of orders.
     */
    List<Order> queryOrders(Account account, Page page);

}
