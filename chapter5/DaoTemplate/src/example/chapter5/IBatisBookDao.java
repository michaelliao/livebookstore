package example.chapter5;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * BookDao implementation using iBatis.
 * 
 * @author Xuefeng
 */
public class IBatisBookDao extends SqlMapClientDaoSupport implements BookDao {

    @SuppressWarnings("unchecked")
    public List<Book> queryAll() {
        return getSqlMapClientTemplate().queryForList("queryAll");
    }

    @SuppressWarnings("unchecked")
    public List<Book> queryByAuthor(String author) {
        return getSqlMapClientTemplate().queryForList("queryByAuthor", author);
    }

    public void create(Book book) {
        getSqlMapClientTemplate().insert("create", book);
    }

    public void delete(String id) {
        getSqlMapClientTemplate().delete("delete", id);
    }

    public void update(Book book) {
        getSqlMapClientTemplate().update("update", book);
    }

}
