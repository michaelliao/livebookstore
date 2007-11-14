package example.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of BookDao.
 */
public class DbBookDao implements BookDao {

    public List<Book> listAll() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Design Patterns", "Erich Gamma"));
        books.add(new Book("Thinking in Java", "Bruce Eckel"));
        books.add(new Book("J2EE Development without EJB", "Rod Johnson"));
        books.add(new Book("J2EE Design & Development", "Rod Johnson"));
        books.add(new Book("Introduction to Algorithms", "Thomas H.Cormen"));
        return books;
    }

}
