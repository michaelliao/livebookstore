package example.chapter9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println(((Greeting)context.getBean("jruby")).getMessage());
        System.out.println(((Greeting)context.getBean("groovy")).getMessage());
        System.out.println(((Greeting)context.getBean("bsh")).getMessage());
    }

}
