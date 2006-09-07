package com.crackj2ee.bookstore.business.impl;

import java.io.Serializable;
import java.util.List;

import com.crackj2ee.bookstore.business.BusinessService;
import com.crackj2ee.bookstore.dao.*;
import com.crackj2ee.bookstore.domain.*;

/**
 * Implementation of BusinessService interface.<br/>
 * NOTE: If using spring declarative transaction management, set id 
 * to "businessServiceTarget", and AOP-wrapped object's id is set to 
 * "businessService".
 * 
 * @author xuefeng
 * 
 * @spring.bean id="businessServiceTarget"
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

    public Object query(Class clazz, Serializable id) {
        if(clazz==Account.class)
            return accountDao.query(id);
        if(clazz==Category.class)
            return categoryDao.query(id);
        if(clazz==Book.class)
            return bookDao.query(id);
        if(clazz==Order.class)
            return orderDao.query(id);
        throw new IllegalArgumentException("Unsupported class: " + clazz.getName());
    }

    public void create(Object object) {
        if(object instanceof Account)
            accountDao.create((Account)object);
        else if(object instanceof Book)
            bookDao.create((Book)object);
        else if(object instanceof Comment)
            commentDao.create((Comment)object);
        else
            throw new IllegalArgumentException("Unsupported object: " + object.getClass().getName());
    }

    public void create(Category category, Integer parentId) {
        categoryDao.create(category, parentId);
    }

    public void update(Object object) {
        if(object instanceof Category)
            categoryDao.update((Category)object);

    }

    public void delete(Object object) {
        if(object instanceof Category)
            categoryDao.delete((Category)object);
        if(object instanceof Book)
            bookDao.delete((Book)object);
        // TODO Auto-generated method stub

    }

    public Account login(String username, String password) {
        return accountDao.login(username, password);
    }

    public Category queryRoot() {
        return categoryDao.queryRoot();
    }

    public List queryBooks(Category c, Page page) {
        return bookDao.query(c, page);
    }

    public List queryTopSales(Category c, int max) {
        return bookDao.queryTopSales(c, max);
    }

}
