package net.livebookstore.dao.hibernate;

import java.util.*;

import net.livebookstore.domain.*;

import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;

import net.livebookstore.dao.BookDao;

/**
 * Implementation of BookDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="bookDao"
 */
public class BookDaoImpl extends GenericHibernateDao<Book> implements BookDao {

    public BookDaoImpl() {
        super(Book.class);
    }

    @SuppressWarnings("unchecked")
    public List<Book> query(final Category c, final Page page) {
        return queryForList(
                "select count(*) from Book as b where bitand(b.categoryId, ?) = ?",
                "select b from Book as b where bitand(b.categoryId, ?) = ? order by b.pubDate desc",
                new Object[] {c.getMask(), c.getId()},
                page
        );
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryFavorite(Account account, Page page) {
        return queryForList(
                "select count(*) from FavoriteBook as fb inner join fb.book as b where fb.account=?",
                "select new Book(b.id, b.name, b.price, b.discount) from FavoriteBook as fb inner join fb.book as b where fb.account=? order by fb.createdDate desc",
                new Object[]{account},
                page
        );
    }

    public boolean createFavorite(Account account, Book book) {
        Long count = (Long)queryForObject(
                "select count(*) from FavoriteBook as fb where fb.account=? and fb.book=?",
                new Object[] {account, book}
        );
        if(count.longValue()==0) {
            FavoriteBook fb = new FavoriteBook();
            fb.setAccount(account);
            fb.setBook(book);
            fb.setCreatedDate(new Date());
            hibernateTemplate.save(fb);
            return true;
        }
        return false;
    }

    public void deleteFavorite(final Account account, final Book book) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                session.createQuery("delete from FavoriteBook as fb where fb.account=:a and fb.book=:b")
                       .setEntity("a", account)
                       .setEntity("b", book)
                       .executeUpdate();
                return null;
            }
        };
        hibernateTemplate.execute(action);
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryTopSales(final Category c, final int max) {
        Page page = new Page(1, max);
        return queryForList(
                "from Book as b where bitand(b.categoryId, ?) = ? and b.state=0 and b.sold > 0 order by b.sold, b.pubDate desc",
                new Object[] {c.getMask(), c.getId()},
                page
        );
    }

    public void updateSold(Book book, int sold) {
        executeUpdate(
                "update Book as b set b.sold=b.sold+?, b.stock=b.stock-? where b.id=?",
                new Object[] {new Integer(sold), new Integer(sold), book.getId()}
        );
    }

}
