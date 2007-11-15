package example.chapter6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        HsqldbUtil.startDatabase();
        // change to "config2.xml" or "config3.xml":
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BookDao bookDao = (BookDao)context.getBean("bookDao");
        display(bookDao.queryAll());
        try {
            Book newBook = new Book();
            newBook.setId("new-id-1234567890");
            newBook.setName("New Book");
            newBook.setAuthor("New Author");
            bookDao.insert(newBook);
        }
        catch(Exception e) {
            System.out.println(e.getClass().getName());
        }
        display(bookDao.queryAll());
        System.exit(0);
    }

    private static void display(List<Book> books) {
        System.err.println("-- All Books ---------------------------");
        for(Book book : books) {
            System.err.println("  " + book.getName() + ", by " + book.getAuthor());
        }
        System.err.println("----------------------------------------");
    }

}
