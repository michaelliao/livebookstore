package example.chapter5.swing;

import java.util.*;

import javax.swing.table.*;

import example.chapter5.*;

/**
 * Hold table data.
 * 
 * @author Li Jianghua
 */
public class BookTableModel extends AbstractTableModel {

    private List<Book> bookList;
    private BookDao bookDao;

    public BookTableModel(BookDao dao) {
        bookDao = dao;
        bookList = bookDao.queryAll();
    }

    public void refresh(String author) {
        if (author == null || author.trim().equals("")) {
            bookList = bookDao.queryAll();
        } else {
            bookList = bookDao.queryByAuthor(author.trim());
        }
        fireTableDataChanged();
    }

    public void removeBook(Book book) {
        bookDao.delete(book.getId());
        bookList.remove(book);
        fireTableDataChanged();
    }

    public void updateBook(Book book) {
        bookDao.update(book);
        fireTableDataChanged();
    }

    public void createBook(Book book) {
        bookDao.create(book);
        refresh(null);
    }

    public Book getBook(int index) {
        return bookList.get(index);
    }

    public int getRowCount() {
        return bookList.size();
    }

    public int getColumnCount() {
        return BookHelper.getColumnCount();
    }

    public Object getValueAt(int row, int column) {
        Book item = bookList.get(row);
        return BookHelper.getValueAt(item, column);
    }

    public void setValueAt(Object obj, int row, int column) {
        Book item = bookList.get(row);
        BookHelper.setValueAt(item, obj, column);
    }

    public String getColumnName(int index) {
        return BookHelper.getColumnName(index);
    }

    public boolean isCellEditable(int row, int column) {
        return column > 0;
    }
}
