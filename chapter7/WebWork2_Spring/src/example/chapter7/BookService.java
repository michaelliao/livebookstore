package example.chapter7;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book getBook(String isbn);

}
