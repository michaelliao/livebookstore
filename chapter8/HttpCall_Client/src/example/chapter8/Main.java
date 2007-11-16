package example.chapter8;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main extends JFrame {

    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(context).setVisible(true);
            }
        });
    }

    private ApplicationContext context;

    public Main(ApplicationContext context) {
        this.context = context;
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Vector<String> vector = new Vector<String>();
        vector.add("hessianService");
        vector.add("burlapService");
        vector.add("springHttpService");
        final JComboBox comboBeans = new JComboBox(vector);
        JButton buttonInvoke = new JButton("Invoke");
        final JTextField textResult = new JTextField();
        textResult.setEditable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JLabel("选择HttpCall："), BorderLayout.LINE_START);
        getContentPane().add(comboBeans, BorderLayout.CENTER);
        getContentPane().add(buttonInvoke, BorderLayout.LINE_END);
        getContentPane().add(textResult, BorderLayout.PAGE_END);

        buttonInvoke.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                String beanName = comboBeans.getSelectedItem().toString();
                TimeService service = (TimeService)context.getBean(beanName);
                try {
                    textResult.setText(service.getTime());
                }
                catch(Exception e) {
                    textResult.setText(e.getClass().getName());
                }
            }
        });
        pack();
    }

}
