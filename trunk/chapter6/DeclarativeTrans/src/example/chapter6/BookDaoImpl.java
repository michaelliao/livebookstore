package example.chapter6;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

    public Book query(String id) {
        return (Book)getJdbcTemplate().queryForObject(
                "select * from Book where id=?",
                new Object[]{id},
                new BookRowMapper());
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryAll() {
        return getJdbcTemplate().query(
                "select * from Book",
                new BookRowMapper());
    }

    public void insert(Book book) {
        getJdbcTemplate().update(
                "insert into Book(id, name, author) values(?,?,?)",
                new Object[] {book.getId(), book.getName(), book.getAuthor()});
        //throw new UnsupportedOperationException("Cause rollback");
    }

    public void update(Book book) {
        getJdbcTemplate().update(
                "update Book set name=?, author=? where id=?",
                new Object[] {book.getName(), book.getAuthor(), book.getId()});
    }

    public void delete(Book book) {
        getJdbcTemplate().update(
                "delete from Book where id=?",
                new Object[] {book.getId()});
    }

}

class BookRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getString("id"));
        book.setName(rs.getString("name"));
        book.setAuthor(rs.getString("author"));
        return book;
    }
}
