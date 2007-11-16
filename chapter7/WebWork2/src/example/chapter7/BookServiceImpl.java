package example.chapter7;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private List<Book> books = new ArrayList<Book>();

    public BookServiceImpl() {
        books.add(new Book("0131872486", "Thinking in Java", "Bruce Eckel"));
        books.add(new Book("0201633612", "Design Patterns", "Erich Gamma"));
        books.add(new Book("0201310058", "Effective Java", "Joshua Bloch"));
        books.add(new Book("0764558315", "J2EE Development without EJB", "Rod Johnson"));
        books.add(new Book("0131482025", "Core Java Volumn I", "Cay Horstmann, Gary Cornell"));
        books.add(new Book("0131118269", "Core Java Volumn II", "Cay Horstmann, Gary Cornell"));
    }

    public Book getBook(String isbn) {
        for(Book book : books) {
            if(book.getIsbn().equals(isbn))
                return book;
        }
        throw new RuntimeException("Book not found.");
    }

    public List<Book> listAll() {
        return books;
    }

}
