package example.chapter7.webwork2;

import example.chapter7.Book;

public class BookDetailAction extends BaseAction {

    private Book book;
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book getBook() {
        return book;
    }

    public String execute() throws Exception {
        try {
            book = getBookService().getBook(isbn);
            return SUCCESS;
        }
        catch(Exception e) {
            return ERROR;
        }
    }

}
