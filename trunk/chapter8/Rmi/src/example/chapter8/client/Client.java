package example.chapter8.client;

import java.rmi.Naming;

import example.chapter8.rmi.RmiUserService;

public class Client {

    public static void main(String[] args) throws Exception {
        RmiUserService service = (RmiUserService)Naming.lookup("rmi://localhost:1099/UserService");
        service.create("new_user", "a_test");
        System.out.println(service.login("new_user", "a_test"));
    }
}
