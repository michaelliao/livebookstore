package example.chapter5;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.dao.DataRetrievalFailureException;

/**
 * BookDao implementation using JDBC directly.
 * 
 * @author Xuefeng
 */
public class JdbcCodeBookDao implements BookDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Book> queryAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from Book");
            List<Book> books = new ArrayList<Book>(10);
            while(rs.next()) {
                Book book = new Book();
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                books.add(book);
            }
            return books;
        }
        catch(SQLException sqle) {
            throw new DataRetrievalFailureException("Retrieval failed.", sqle);
        }
        finally {
            if(rs!=null) {
                try {
                    rs.close();
                }
                catch(SQLException e) {}
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                }
                catch(SQLException e) {}
            }
            if(conn!=null) {
                try {
                    conn.close();
                }
                catch(SQLException e) {}
            }
        }
    }

    public List<Book> queryByAuthor(String author) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("select * from Book where author=?");
            ps.setString(1, author);
            rs = ps.executeQuery();
            List<Book> books = new ArrayList<Book>(10);
            while(rs.next()) {
                Book book = new Book();
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                books.add(book);
            }
            return books;
        }
        catch(SQLException sqle) {
            throw new DataRetrievalFailureException("Retrieval failed.", sqle);
        }
        finally {
            if(rs!=null) {
                try {
                    rs.close();
                }
                catch(SQLException e) {}
            }
            if(ps!=null) {
                try {
                    ps.close();
                }
                catch(SQLException e) {}
            }
            if(conn!=null) {
                try {
                    conn.close();
                }
                catch(SQLException e) {}
            }
        }
    }

    public void create(Book book) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("insert into Book (id, name, author) values (?, ?, ?)");
            ps.setString(1, book.getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.executeUpdate();
        }
        catch(SQLException sqle) {
            throw new DataRetrievalFailureException("Create failed.", sqle);
        }
        finally {
            if(ps!=null) {
                try {
                    ps.close();
                }
                catch(SQLException e) {}
            }
            if(conn!=null) {
                try {
                    conn.close();
                }
                catch(SQLException e) {}
            }
        }
    }

    public void update(Book book) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("update Book set name=?, author=? where id=?");
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getId());
            ps.executeUpdate();
        }
        catch(SQLException sqle) {
            throw new DataRetrievalFailureException("Update failed.", sqle);
        }
        finally {
            if(ps!=null) {
                try {
                    ps.close();
                }
                catch(SQLException e) {}
            }
            if(conn!=null) {
                try {
                    conn.close();
                }
                catch(SQLException e) {}
            }
        }
    }

    public void delete(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("delete from Book where id=?");
            ps.setString(1, id);
            ps.executeUpdate();
        }
        catch(SQLException sqle) {
            throw new DataRetrievalFailureException("Delete failed.", sqle);
        }
        finally {
            if(ps!=null) {
                try {
                    ps.close();
                }
                catch(SQLException e) {}
            }
            if(conn!=null) {
                try {
                    conn.close();
                }
                catch(SQLException e) {}
            }
        }
    }
}
