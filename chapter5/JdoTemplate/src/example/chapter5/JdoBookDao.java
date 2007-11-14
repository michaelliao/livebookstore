package example.chapter5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.orm.jdo.support.JdoDaoSupport;

/**
 * BookDao implementation using JDO.
 * 
 * @author Xuefeng
 */
public class JdoBookDao extends JdoDaoSupport implements BookDao {

    public List<Book> queryAll() {
        Collection c = getJdoTemplate().find(Book.class);
        List<Book> books = new ArrayList<Book>();
        books.addAll(c);
        return books;
    }

    public List<Book> queryByAuthor(String author) {
        // query: class, filters, parameters, values
        Collection c = getJdoTemplate().find(Book.class,
                "author==a", "String a", new Object[] { author });
        List<Book> books = new ArrayList<Book>();
        books.addAll(c);
        return books;
    }

    public void create(Book book) {
        getJdoTemplate().makePersistent(book);
    }

    public void delete(String id) {
        Book book = (Book) getJdoTemplate().getObjectById(Book.class, id);
        getJdoTemplate().deletePersistent(book);
    }

    public void update(Book book) {
        Book b = (Book) getJdoTemplate().getObjectById(Book.class, book.getId());
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        getJdoTemplate().makePersistent(b);
    }

}
