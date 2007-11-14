package example.chapter5;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * BookDao implementation using Hibernate.
 * 
 * @author Xuefeng
 */
public class HibernateBookDao extends HibernateDaoSupport implements BookDao {

    @SuppressWarnings("unchecked")
    public List<Book> queryAll() {
        return getHibernateTemplate().find("select b from Book as b");
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryByAuthor(String author) {
        return getHibernateTemplate().find("select b from Book as b where b.author=?", author);
    }

    public void create(Book book) {
        getHibernateTemplate().save(book);
    }

    public void delete(String id) {
        Book book = (Book) getHibernateTemplate().load(Book.class, id);
        getHibernateTemplate().delete(book);
    }

    public void update(Book book) {
        getHibernateTemplate().update(book);
    }

}
