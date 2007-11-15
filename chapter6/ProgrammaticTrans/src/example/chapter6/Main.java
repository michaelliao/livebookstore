package example.chapter6;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class Main {

    public static void main(String[] args) {
        HsqldbUtil.startDatabase();
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        queryAllBooks(dataSource);
        // 获取PlatformTransactionManager:
        PlatformTransactionManager transManager = (PlatformTransactionManager)context.getBean("transactionManager");
        try {
            doTransaction(transManager, dataSource);
        }
        finally {
            queryAllBooks(dataSource);
            System.exit(0);
        }
    }

    private static void doTransaction(PlatformTransactionManager transManager, DataSource dataSource) {
        // 定义TransactionDefinition:
        DefaultTransactionDefinition transDef = new DefaultTransactionDefinition();
        transDef.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        // 开始一个Transaction:
        TransactionStatus ts = transManager.getTransaction(transDef);
        try {
            insertBook(dataSource);
            // insertBook(dataSource);
        }
        catch(RuntimeException e) {
            e.printStackTrace();
            // 回滚事务:
            transManager.rollback(ts);
            throw e;
        }
        catch(Error e) {
            e.printStackTrace();
            // 回滚事务:
            transManager.rollback(ts);
            throw e;
        }
        // 提交事务:
        transManager.commit(ts);
    }

    private static void queryAllBooks(DataSource dataSource) {
        List<Book> books = new JdbcTemplate(dataSource).query("select * from Book", new BookRowMapper());
        System.err.println("-- All Books ---------------------------");
        for(Book book : books) {
            System.err.println("  " + book.getName() + ", by " + book.getAuthor());
        }
        System.err.println("----------------------------------------");
    }

    private static void insertBook(DataSource dataSource) {
        JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
        jdbcTemp.update(
                "insert into Book(id, name, author) values(?, ?, ?)",
                new Object[]{"123-456-789", "New Book", "New Author"});
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
