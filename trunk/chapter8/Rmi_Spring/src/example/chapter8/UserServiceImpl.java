package example.chapter8;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private Map<String, String> users = new HashMap<String, String>();

    public void create(String username, String password) {
        if(username==null || password==null)
            throw new IllegalArgumentException("Invalid args.");
        if(users.get(username)!=null)
            throw new RuntimeException("User exist!");
        users.put(username, password);
    }

    public User login(String username, String password) {
        if(username==null || password==null)
            throw new IllegalArgumentException("Invalid args.");
        if(password.equals(users.get(username)))
            return new User(username, password);
        throw new RuntimeException("Login failed.");
    }

}
