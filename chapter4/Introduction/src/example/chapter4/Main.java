package example.chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        User user = (User)context.getBean("user");
        System.out.println(user.getEmail());
        ((Mutable)user).setReadonly(true);
        System.out.println(((Mutable)user).getReadonly());
        user.setEmail("new-email@abc.xyz");
        System.out.println(user.getEmail());
    }

}
