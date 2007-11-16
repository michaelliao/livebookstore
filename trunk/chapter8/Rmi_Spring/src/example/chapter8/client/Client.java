package example.chapter8.client;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import example.chapter8.UserService;

public class Client {

    public static void main(String[] args) throws Exception {
        RmiProxyFactoryBean factory = new RmiProxyFactoryBean();
        factory.setServiceInterface(UserService.class);
        factory.setServiceUrl("rmi://localhost:1099/UserService");
        factory.afterPropertiesSet();
        UserService userService = (UserService)factory.getObject();
        userService.create("test", "password");
        System.out.println(userService.login("test", "password"));
        try {
            userService.login("test", "bad-password");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
