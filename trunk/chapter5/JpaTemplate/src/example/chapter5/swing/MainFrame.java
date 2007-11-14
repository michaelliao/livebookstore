package example.chapter5.swing;

import javax.swing.*;
import java.awt.event.*;

import example.chapter5.BookDao;

/**
 * Main Frame for GUI.
 * 
 * @author Xuefeng
 */
public class MainFrame extends JFrame{

    private BookDao bookDao;

    public MainFrame(BookDao dao) {
        super("BookDao");
        bookDao = dao;
        setContentPane(new BookPane(this));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                shutDown();
            }
        });
        setSize(600, 400);
        setVisible(true);
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void shutDown() {
        System.exit(0);
    }
}
