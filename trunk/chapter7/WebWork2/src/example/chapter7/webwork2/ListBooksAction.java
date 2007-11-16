package example.chapter7.webwork2;

import java.util.List;

import example.chapter7.Book;

public class ListBooksAction extends BaseAction {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public String execute() throws Exception {
        books = getBookService().listAll();
        return SUCCESS;
    }

}
