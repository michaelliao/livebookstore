package example.chapter5;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * BookDao implementation using JPA.
 * 
 * @author Xuefeng
 */
public class JpaBookDao extends JpaDaoSupport implements BookDao {

    @SuppressWarnings("unchecked")
    public List<Book> queryAll() {
        return getJpaTemplate().find("select b from Book b");
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryByAuthor(String author) {
        return getJpaTemplate().find("select b from Book b where b.author=?", new Object[] { author });
    }

    public void create(Book book) {
        getJpaTemplate().persist(book);
    }

    public void delete(String id) {
        Book book = getJpaTemplate().find(Book.class, id);
        getJpaTemplate().remove(book);
    }

    public void update(Book book) {
        getJpaTemplate().merge(book);
    }

}
