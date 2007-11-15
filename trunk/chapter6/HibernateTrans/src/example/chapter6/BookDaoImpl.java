package example.chapter6;

import java.util.List;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import example.chapter6.Book;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

    public Book query(String id) {
        Object obj = getHibernateTemplate().load(Book.class, id);
        if(obj==null)
            throw new DataRetrievalFailureException("id not found: " + id);
        return (Book) obj;
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryAll() {
        return getHibernateTemplate().find("select b from Book as b");
    }

    public void insert(Book book) {
        getHibernateTemplate().save(book);
    }

    public void update(Book book) {
        getHibernateTemplate().update(book);
    }

    public void delete(Book book) {
        getHibernateTemplate().delete(
                getHibernateTemplate().load(Book.class, book.getId()));
    }

}
