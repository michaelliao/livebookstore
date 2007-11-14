package example.chapter3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println(context.getBean("a1"));
        System.out.println(context.getBean("a2"));
    }
}
