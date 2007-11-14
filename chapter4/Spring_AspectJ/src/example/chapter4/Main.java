package example.chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = (UserService) context.getBean("userService");
        try {
            userService.create("new_user", "new_password");
            userService.login("new_user", "new_password");
            userService.login("bad_user", "bad_password");
        }
        catch(Exception e) {}
        try {
            userService.login("admin", "admin_password");
        }
        catch(Exception e) {}
    }

}
