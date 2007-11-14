package example.chapter5.swing;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import example.chapter5.*;

/** 
 * @author Li Jianghua
 */
public class TablePane extends JPanel {

    private JScrollPane tablePane;
    private JTable table;
    private DefaultCellEditor cellEditor;
    private JTextField txtEditor;

    BookTableModel tableModel;
    MainFrame mainFrame;

    public TablePane(MainFrame frame) {
        super(new BorderLayout());
        mainFrame = frame;
        initTable();
        tablePane = new JScrollPane(table);
        add(tablePane, BorderLayout.CENTER);
    }

    public void refresh(String author) {
        tableModel.refresh(author);
    }

    public void createBook(Book book) {
        tableModel.createBook(book);
    }

    public void updateBook(Book book) {
        tableModel.updateBook(book);
    }

    public void removeBook(Book book) {
        tableModel.removeBook(book);
    }

    public Book getSelectedBook() {
        Book item = null;
        int index = table.getSelectedRow();
        if (index != -1) {
            item = tableModel.getBook(index);
        }
        return item;
    }

    private void initTable() {
        tableModel = new BookTableModel(mainFrame.getBookDao());
        txtEditor = new JTextField();
        cellEditor = new MyCellEditor(txtEditor);

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumnModel().getColumn(1).setCellEditor(cellEditor);
        table.getColumnModel().getColumn(2).setCellEditor(cellEditor);
        cellEditor.addCellEditorListener(new CellEditorListener() {
            public void editingCanceled(ChangeEvent e) {
                /* Nothing to do */
            }

            public void editingStopped(ChangeEvent e) {
                Book book = tableModel.getBook(table.getSelectedRow());
                tableModel.updateBook(book);
            }
        });
    }

    class MyCellEditor extends DefaultCellEditor {
        public MyCellEditor(JTextField tf) {
            super(tf);
        }

        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            delegate.setValue(value);
            if (isSelected) {
                txtEditor.selectAll();
            }
            return txtEditor;
        }
    }
}
