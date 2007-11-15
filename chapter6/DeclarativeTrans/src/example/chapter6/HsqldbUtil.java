package example.chapter6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Server;

public class HsqldbUtil {

    private static final String DROP_TABLE = "drop table Book if exists";
    private static final String CREATE_TABLE = "create table Book "
        + "(id varchar(36) not null primary key, "
        + "name varchar(100) not null, "
        + "author varchar(100) not null)";
    private static final String INSERT_BOOK1 = "insert into Book "
        + "(id, name, author) values "
        + "('12345678-abcd-effe-dcba-87654321', 'Thinking in Java', 'Bruce Eckel')";
    private static final String INSERT_BOOK2 = "insert into Book "
        + "(id, name, author) values "
        + "('abcdefed-cba9-8765-4321-01234567', 'JUnit in Action', 'Craig Walls')";

    private static Server server = null;

    public static void startDatabase() {
        server = new Server();
        server.setDatabaseName(0, "test");
        server.setDatabasePath(0, "mem:bookstore");
        server.setLogWriter(null);
        server.setErrWriter(null);
        server.start();
        try {
            Class.forName("org.hsqldb.jdbcDriver" );
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Connection c = null;
        Statement st = null;
        try {
            c = DriverManager.getConnection("jdbc:hsqldb:mem:bookstore", "sa", "");
            st = c.createStatement();
            st.execute(DROP_TABLE);
            st.execute(CREATE_TABLE);
            st.execute(INSERT_BOOK1);
            st.execute(INSERT_BOOK2);
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(st!=null) {
                try {
                    st.close();
                }
                catch(SQLException e) {}
            }
            if(c!=null) {
                try {
                    c.close();
                }
                catch(SQLException e) {}
            }
        }
    }

}
