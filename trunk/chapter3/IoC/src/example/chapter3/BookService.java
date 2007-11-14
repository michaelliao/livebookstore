package example.chapter3;

import java.util.Iterator;
import java.util.List;

/**
 * BookService.
 */
public class BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> listAll() {
        return bookDao.listAll();
    }

    public List<Book> listBooksByAuthor(String author) {
        List<Book> books = bookDao.listAll();
        Iterator<Book> it = books.iterator();
        while(it.hasNext()) {
            if(!it.next().getAuthor().equals(author))
                it.remove();
        }
        return books;
    }

}
