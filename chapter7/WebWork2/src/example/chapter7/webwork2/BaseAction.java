package example.chapter7.webwork2;

import com.opensymphony.xwork.Action;

import example.chapter7.BookService;
import example.chapter7.BookServiceImpl;

public abstract class BaseAction implements Action {

    private static BookService bookService = new BookServiceImpl();

    public BookService getBookService() {
        return bookService;
    }

}
