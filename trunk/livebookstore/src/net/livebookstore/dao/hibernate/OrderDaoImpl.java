package net.livebookstore.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import net.livebookstore.domain.Account;
import net.livebookstore.domain.Order;
import net.livebookstore.domain.OrderItem;
import net.livebookstore.domain.Page;

import net.livebookstore.dao.OrderDao;
import net.livebookstore.exception.OrderException;

/**
 * Implementation of OrderDao.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="orderDao"
 */
public class OrderDaoImpl extends GenericHibernateDao<Order> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }

    public void create(Order order, List<OrderItem> items) {
        int payment = order.getPayment();
        if(payment==Order.PAYMENT_FACE_TO_FACE)
            order.setState(Order.STATE_WATING_FOR_HANDLE);
        else
            order.setState(Order.STATE_WAITING_FOR_PAY);
        hibernateTemplate.save(order);
        for(OrderItem item : items) {
            item.setOrder(order);
            hibernateTemplate.save(item);
        }
        // make sure "order.getOrderItems()" is not null:
        order.setOrderItems(items);
    }

    @SuppressWarnings("unchecked")
    public List<Order> queryOrders(Account account, Page page) {
        String selectCount = "select count(*) from Order as o where o.account=?";
        String select = "select o from Order as o where o.account=? order by o.createdDate desc";
        return queryForList(selectCount, select, new Object[] {account}, page);
    }

    @SuppressWarnings("unchecked")
    public List<Order> queryOrders(Page page) {
        String selectCount = "select count(*) from Order as o";
        String select = "select o from Order as o order by o.createdDate desc";
        return queryForList(selectCount, select, EMPTY_OBJECT_ARRAY, page);
    }

    /**
     * DO NOT allow create Order object only. Using create(Order, List<OrderItem>) 
     * instead.
     * 
     * @throws UnsupportedOperationException This exception is throw immediately 
     * if calling this method.
     */
    @Override
    public void create(Order order) {
        throw new UnsupportedOperationException("Use create(Order, List<OrderItem>) instead.");
    }

    @Override
    public void delete(Order t) {
        // only when order is not processed yet:
        if(!t.canCancel())
            throw new OrderException("无法删除正在处理中的订单。");
        // delete each OrderItem:
        for(OrderItem item : t.getOrderItems())
            hibernateTemplate.delete(item);
        // delete Order object:
        hibernateTemplate.delete(t);
    }

    @Override
    public Order query(Serializable id) {
        Order order = super.query(id);
        hibernateTemplate.initialize(order.getOrderItems());
        return order;
    }

}
