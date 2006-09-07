package com.crackj2ee.bookstore.dao.hibernate;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.crackj2ee.bookstore.dao.CommentDao;
import com.crackj2ee.bookstore.domain.*;

/**
 * Implementation of CommentDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="commentDao"
 */
public class CommentDaoImpl extends GenericHibernateDaoSupportImpl<Comment> implements CommentDao {

    public CommentDaoImpl() {
        super(Comment.class);
    }

    @Override
    public void create(final Comment comment) {
        hibernateTemplate.save(comment);
        // update book's average rating and rating count:
        HibernateCallback countQuery = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                return session.createQuery("select count(*) from Comment as c where c.book=:book")
                    .setEntity("book", comment.getBook())
                    .uniqueResult();
            }
        };
        HibernateCallback sumQuery = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                return session.createQuery("select sum(c.rating) from Comment as c where c.book=:book")
                    .setEntity("book", comment.getBook())
                    .uniqueResult();
            }
        };
        Long sum = (Long)hibernateTemplate.execute(sumQuery);
        Long count = (Long)hibernateTemplate.execute(countQuery);
        float avg = (int)(sum.floatValue() / count.longValue() * 100) / 100f;
        Book book = comment.getBook();
        book.setRating(avg);
        book.setRatingCount(count.intValue());
        hibernateTemplate.save(book);
    }

    @Override
    public void delete(Comment t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Comment t) {
        throw new UnsupportedOperationException();
    }

}
