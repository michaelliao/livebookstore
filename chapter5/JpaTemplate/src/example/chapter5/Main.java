package example.chapter5;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.chapter5.swing.DaoSelectDialog;
import example.chapter5.swing.MainFrame;

/**
 * Application entry.
 * 
 * @author Xuefeng
 */
public class Main {

    public static void main(String[] args) {
        HsqldbUtil.startDatabase();
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // 可供选择的DAO:
        String[] selections = {"jpaBookDao"};
        // 弹出对话框让用户选择:
        DaoSelectDialog dialog = new DaoSelectDialog(selections);
        if(dialog.showDialog(null)==JOptionPane.OK_OPTION) {
            String daoName = dialog.getSelected().toString();
            System.out.println("Select >> " + daoName);
            BookDao bookDao = (BookDao) context.getBean(daoName);
            new MainFrame(bookDao);
        }
    }

}
