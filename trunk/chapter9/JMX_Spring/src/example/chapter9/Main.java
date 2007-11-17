package example.chapter9;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("config.xml");
    }
}
