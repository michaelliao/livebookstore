package example.chapter5;

import java.sql.*;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * BookDao implementation using JdbcTemplate provieded by Spring.
 * 
 * @author Xuefeng
 */
public class JdbcTemplateBookDao extends JdbcDaoSupport implements BookDao {

    class BookRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getString("id"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            return book;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryAll() {
        return getJdbcTemplate().query(
                "select * from Book",
                new BookRowMapper());
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryByAuthor(String author) {
        return getJdbcTemplate().query(
                "select * from Book where author=?",
                new Object[] { author },
                new BookRowMapper());
    }

    public void create(Book book) {
        getJdbcTemplate().update(
                "insert into Book (id, name, author) values (?, ?, ?)",
                new Object[] {book.getId(), book.getName(), book.getAuthor()});
    }

    public void update(Book book) {
        getJdbcTemplate().update(
                "update Book set name=?, author=? where id=?",
                new Object[] {book.getName(), book.getAuthor(), book.getId()});
    }

    public void delete(String id) {
        getJdbcTemplate().update(
                "delete from Book where id=?",
                new Object[] {id});
    }

}
