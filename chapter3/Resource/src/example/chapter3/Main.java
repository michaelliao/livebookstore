package example.chapter3;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new FileSystemXmlApplicationContext("classpath:config.xml");
    }
}
