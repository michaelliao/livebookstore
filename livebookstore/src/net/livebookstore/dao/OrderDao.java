package net.livebookstore.dao;

import java.util.List;

import net.livebookstore.domain.*;

/**
 * Define Order operations.
 * 
 * @author xuefeng
 */
public interface OrderDao extends GenericDao<Order> {

    /**
     * Create order object.
     * 
     * @param order Order object.
     * @param items OrderItem objects belong to this order.
     */
    void create(Order order, List<OrderItem> items);

    /**
     * Query all orders.
     * 
     * @param page Page objects.
     * @return List of orders.
     */
    List<Order> queryOrders(Page page);

    /**
     * Query orders belong to specified account.
     * 
     * @param account Account object.
     * @param page Page object.
     * @return List of orders.
     */
    List<Order> queryOrders(Account account, Page page);

}
