package example.chapter3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext parent = new ClassPathXmlApplicationContext("config-1.xml");
        ApplicationContext child = new ClassPathXmlApplicationContext(new String[] {"config-2.xml"}, parent);
        for(String name : child.getBeanDefinitionNames()) {
            System.out.println("[Bean: " + name + "] " + child.getBean(name));
        }
        System.out.println("----------");
        for(int i=1; i<=3; i++) {
            String name = "parent-" + i;
            System.out.println("[Bean: " + name + "] " + child.getBean(name));
        }
    }
}
