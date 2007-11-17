package example.chapter9;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        Mom4jUtil.startJmsServer();
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Sender sender = (Sender) context.getBean("sender");
        for(int i=0; i<10; i++) {
            sender.send("Hello, it is " + new Date());
            Thread.sleep(1000);
        }
        System.exit(0);
    }
}
