package example.chapter6;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookDao {

    @Transactional(readOnly=true)
    Book query(String id);

    @Transactional(readOnly=true)
    List<Book> queryAll();

    void insert(Book book);

    void update(Book book);

    void delete(Book book);

}
