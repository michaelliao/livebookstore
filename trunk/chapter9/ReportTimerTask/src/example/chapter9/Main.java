package example.chapter9;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("config.xml");
        // 等待5分钟,观察输出:
        try {
            Thread.sleep(300000);
        }
        catch(InterruptedException e) {}
        System.exit(0);
    }

}
