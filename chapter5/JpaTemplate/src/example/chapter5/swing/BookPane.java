package example.chapter5.swing;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.UUID;

import javax.swing.border.TitledBorder;

import example.chapter5.*;

/**
 * Pane for GUI.
 * 
 * @author Li Jianghua
 */
public class BookPane extends JPanel {

    private JPanel searchPane = new JPanel();
    private InputEditor inputEditor = new InputEditor();
    private JButton btnSearch = new JButton();
    private BorderLayout borderLayout = new BorderLayout();
    private JPanel ctrlPane = new JPanel();
    private JPanel addNewPane = new JPanel();
    private JButton btnRemove = new JButton();
    private InputEditor bookName = new InputEditor();
    private InputEditor bookAuthor = new InputEditor();
    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    private JButton btnNew = new JButton();
    private GridBagLayout gridBagLayout2 = new GridBagLayout();
    private TitledBorder titledBorder = new TitledBorder("");

    private MainFrame mainFrame;
    private TablePane tablePane;

    public BookPane(MainFrame frame) {
        mainFrame = frame;
        tablePane = new TablePane(mainFrame);
        try {
            init();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void init() throws Exception {
        inputEditor.setLabelText("作者:");
        btnSearch.setText("查询");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSearch_actionPerformed(e);
            }
        });
        this.setLayout(borderLayout);
        btnRemove.setText("删除");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRemove_actionPerformed(e);
            }
        });
        ctrlPane.setLayout(gridBagLayout2);
        bookName.setLabelText("书名:");
        bookAuthor.setLabelText("作者:");
        addNewPane.setLayout(gridBagLayout1);
        btnNew.setText("添加");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNew_actionPerformed(e);
            }
        });
        titledBorder.setTitle("新增:");
        addNewPane.setBorder(titledBorder);
        searchPane.add(inputEditor);
        searchPane.add(btnSearch);
        this.add(tablePane, java.awt.BorderLayout.CENTER);
        this.add(addNewPane, java.awt.BorderLayout.SOUTH);
        this.add(searchPane, java.awt.BorderLayout.NORTH);
        this.add(ctrlPane, java.awt.BorderLayout.EAST);

        ctrlPane.add(btnRemove, new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0
                , GridBagConstraints.NORTH, GridBagConstraints.NONE,
                new Insets(6, 5, 0, 5), 0, 0));
        addNewPane.add(bookName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                new Insets(0, 5, 0, 5), 0, 0));
        addNewPane.add(bookAuthor, new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                new Insets(6, 6, 6, 6), 0, 0));
        addNewPane.add(btnNew, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
    }

    public void btnSearch_actionPerformed(ActionEvent e) {
        //do search here
        tablePane.refresh(inputEditor.getEditorText());
    }

    public void btnNew_actionPerformed(ActionEvent e) {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setName(bookName.getEditorText());
        book.setAuthor(bookAuthor.getEditorText());
        try {
            tablePane.createBook(book);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            showMessage("添加书籍失败");
        }
    }

    public void btnUpdate_actionPerformed(ActionEvent e) {
        Book item = tablePane.getSelectedBook();
        if(item == null) {
            showMessage("请选择要更新的书籍");
            return;
        }
        try {
            tablePane.updateBook(item);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            showMessage("更新书籍失败");
        }
    }

    public void btnRemove_actionPerformed(ActionEvent e) {
        Book item = tablePane.getSelectedBook();
        if(item == null) {
            showMessage("请选择要删除的书籍");
            return;
        }
        try {
            tablePane.removeBook(item);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            showMessage("删除书籍失败");
        }
    }

    private void showMessage(String text) {
        JOptionPane.showMessageDialog(this, text, "信息", JOptionPane.INFORMATION_MESSAGE);
    }
}
