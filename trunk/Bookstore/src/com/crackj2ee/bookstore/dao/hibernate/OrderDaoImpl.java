package com.crackj2ee.bookstore.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crackj2ee.bookstore.dao.OrderDao;
import com.crackj2ee.bookstore.domain.Account;
import com.crackj2ee.bookstore.domain.OrderItem;
import com.crackj2ee.bookstore.domain.Page;
import com.crackj2ee.bookstore.exception.ApplicationException;

public class OrderDaoImpl extends GenericHibernateDaoSupportImpl<com.crackj2ee.bookstore.domain.Order> implements OrderDao {

    public OrderDaoImpl() {
        super(com.crackj2ee.bookstore.domain.Order.class);
    }

    public void create(com.crackj2ee.bookstore.domain.Order order, List<OrderItem> items) {
        hibernateTemplate.save(order);
        for(OrderItem item : items) {
            item.setOrder(order);
            hibernateTemplate.save(item);
        }
    }

    @SuppressWarnings("unchecked")
    public List<com.crackj2ee.bookstore.domain.Order> queryOrders(Account account, Page page) {
        DetachedCriteria dc = DetachedCriteria.forClass(com.crackj2ee.bookstore.domain.Order.class)
            .add(Restrictions.eq("account", account))
            .addOrder(org.hibernate.criterion.Order.desc("createdDate"));
        return queryForList(dc, page);
    }

    @Override
    public void create(com.crackj2ee.bookstore.domain.Order t) {
        throw new UnsupportedOperationException("Use create(Order, List<OrderItem>) instead.");
    }

    @Override
    public void delete(com.crackj2ee.bookstore.domain.Order t) {
        // only when order is not processed yet:
        if(t.getState()!=com.crackj2ee.bookstore.domain.Order.STATE_NOT_PROCESS)
            throw new ApplicationException("无法删除正在处理中的订单。");
        // delete each OrderItem:
        for(OrderItem item : t.getOrderItems())
            hibernateTemplate.delete(item);
        // delete Order object:
        hibernateTemplate.delete(t);
    }

}
