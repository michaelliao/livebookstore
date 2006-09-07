package com.crackj2ee.bookstore.dao.hibernate;

import java.util.*;

import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.crackj2ee.bookstore.dao.BookDao;
import com.crackj2ee.bookstore.domain.*;

/**
 * Implementation of BookDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="bookDao"
 */
public class BookDaoImpl extends GenericHibernateDaoSupportImpl<Book> implements BookDao {

    public BookDaoImpl() {
        super(Book.class);
    }

    public List<Book> query(final Category c, final Page page) {
        return queryForList("select count(*) from Book as b where bitand(b.categoryId, ?) = ?",
                            "from Book as b where bitand(b.categoryId, ?) = ? order by b.pubDate desc",
                            new Object[] {c.getMask(), c.getId()},
                            page);
    }

    public List<Book> queryFavorite(Account account, Page page) {
        return null;
    }

    public List<Book> queryTopSales(final Category c, final int max) {
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                return session.createQuery("from Book as b where bitand(b.categoryId, ?) = ? and b.state=0 order by b.sold, b.pubDate desc")
                    .setInteger(0, c.getMask())
                    .setInteger(1, c.getId().intValue())
                    .setMaxResults(max)
                    .setFetchSize(max)
                    .list();
            }
        };
        return hibernateTemplate.executeFind(callback);
    }

}
