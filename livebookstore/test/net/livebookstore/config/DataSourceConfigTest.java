package net.livebookstore.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test data source configuration.
 * 
 * @author Xuefeng
 */
public class DataSourceConfigTest extends SpringEnv {

    @Test
    public void lookupDataSource() {
        Object dataSource = getBean("dataSource");
        assertTrue(dataSource instanceof DataSource);
    }

    @Test
    public void getAndReleaseConnection() throws SQLException {
        DataSource ds = (DataSource)getBean("dataSource");
        Connection conn = ds.getConnection();
        conn.close();
    }
}
