package example.chapter7;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final Map<String, User> users = new HashMap<String, User>();

    public UserServiceImpl() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("password");
        users.put(admin.getUsername(), admin);
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if(user==null)
            throw new RuntimeException("用户不存在");
        if(!user.getPassword().equals(password))
            throw new RuntimeException("口令错误");
        return user;
    }

}
