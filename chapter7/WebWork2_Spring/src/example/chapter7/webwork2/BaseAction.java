package example.chapter7.webwork2;

import com.opensymphony.xwork.Action;

import example.chapter7.BookService;

public abstract class BaseAction implements Action {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public BookService getBookService() {
        return bookService;
    }

}
