package net.livebookstore.business.impl;

import java.io.Serializable;
import java.util.List;

import net.livebookstore.domain.*;

import net.livebookstore.business.BusinessService;
import net.livebookstore.dao.*;
import net.livebookstore.security.SecurityUtil;

/**
 * Implementation of BusinessService interface.<br/>
 * NOTE: <tx:annotation-driven /> will make this object transactional.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="businessService"
 */
public class BusinessServiceImpl implements BusinessService {

    private AccountDao accountDao;
    private BookDao bookDao;
    private CategoryDao categoryDao;
    private CommentDao commentDao;
    private OrderDao orderDao;

    /**
     * @spring.property ref="accountDao"
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @spring.property ref="bookDao"
     */
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * @spring.property ref="categoryDao"
     */
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * @spring.property ref="commentDao"
     */
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    /**
     * @spring.property ref="orderDao"
     */
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Object query(Class clazz, Serializable id) {
        if(clazz==Account.class)
            return accountDao.query(id);
        if(clazz==Category.class)
            return categoryDao.query(id);
        if(clazz==Book.class)
            return bookDao.query(id);
        if(clazz==Order.class) {
            Order order = orderDao.query(id);
            SecurityUtil.assertRoleOrUsername("ROLE_ADMIN", order.getAccount().getUsername());
            return order;
        }
        throw new IllegalArgumentException("Unsupported class: " + clazz.getName());
    }

    public List<Account> queryAccounts(Page page, boolean asc) {
        return accountDao.query(page, asc);
    }

    public List<Comment> queryComments(Book book, Page page) {
        return commentDao.queryComments(book, page);
    }

    public List<Order> queryOrders(Page page) {
        return orderDao.queryOrders(page);
    }

    public List<Order> queryOrders(Account account, Page page) {
        SecurityUtil.assertUsername(account.getUsername());
        return orderDao.queryOrders(account, page);
    }

    public List<Book> queryFavorite(Account account, Page page) {
        SecurityUtil.assertUsername(account.getUsername());
        return bookDao.queryFavorite(account, page);
    }

    public boolean createFavorite(Account account, Book book) {
        SecurityUtil.assertUsername(account.getUsername());
        return bookDao.createFavorite(account, book);
    }

    public Category queryRoot() {
        return categoryDao.queryRoot();
    }

    public List<Book> queryBooks(Category c, Page page) {
        return bookDao.query(c, page);
    }

    public List<Book> queryTopSales(Category c, int max) {
        return bookDao.queryTopSales(c, max);
    }

    public void deleteFavorite(Account account, Book book) {
        SecurityUtil.assertUsername(account.getUsername());
        bookDao.deleteFavorite(account, book);
    }

    public void createAccount(Account account) {
        account.setUsername(account.getUsername().toLowerCase());
        accountDao.create(account);
    }

    public void createBook(Book book) {
        bookDao.create(book);
    }

    public void createComment(Comment comment) {
        SecurityUtil.assertUsername(comment.getAccount().getUsername());
        commentDao.create(comment);
    }

    public void createCategory(Category category, Integer parentId) {
        categoryDao.create(category, parentId);
    }

    public void createOrder(Order order, List<OrderItem> items) {
        SecurityUtil.assertUsername(order.getAccount().getUsername());
        orderDao.create(order, items);
    }

    public void updateAccount(Account account) {
        SecurityUtil.assertUsername(account.getUsername());
        accountDao.update(account);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    public void cancelOrder(Order order) {
        SecurityUtil.assertUsername(order.getAccount().getUsername());
        if(!order.canCancel())
            throw new IllegalArgumentException("订单已在处理中，无法取消");
        order.setState(Order.STATE_CANCELLED);
        orderDao.update(order);
    }

    public void updateOrder(Order order, int newState) {
        // set new state:
        int current = order.getState();
        if(current>=newState)
            throw new IllegalArgumentException("Can not set state from " + current + " to " + newState + ".");
        if(newState==Order.STATE_CANCELLED && !order.canCancel())
            throw new IllegalArgumentException("订单已在处理中，无法取消");
        order.setState(newState);
        orderDao.update(order);
        if(newState==Order.STATE_COMPLETE) {
            // update book:
            List<OrderItem> items = order.getOrderItems();
            for(OrderItem item : items) {
                bookDao.updateSold(item.getBook(), item.getNumber());
            }
        }
    }

    public void delete(Object object) {
        if(object instanceof Category) {
            categoryDao.delete((Category)object);
        }
        else if(object instanceof Book) {
            bookDao.delete((Book)object);
        }
        else if(object instanceof Comment) {
            commentDao.delete((Comment)object);
        }
        else
            throw new IllegalArgumentException("Unsupported object: " + object.getClass().getName());
    }

    public Account queryUserDetails(String username) {
        return accountDao.queryUserDetails(username);
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        SecurityUtil.assertUsername(username);
        accountDao.changePassword(username, oldPassword, newPassword);
    }

}
