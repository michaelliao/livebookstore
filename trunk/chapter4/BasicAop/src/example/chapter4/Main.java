package example.chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.login("admin", "security");
        try {
            userService.login("nobody", "invalid-password");
        }
        catch(Exception e) {}
        userService.create("new_user", "a-test");
    }
}
