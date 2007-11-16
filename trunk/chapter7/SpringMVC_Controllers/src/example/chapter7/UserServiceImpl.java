package example.chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of UserService.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="userService"
 */
public class UserServiceImpl implements UserService {

    private final Map<String, User> users = new HashMap<String, User>();

    public UserServiceImpl() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("password");
        admin.setEmail("admin@javaeedev.com");
        admin.setBlog("http://xuefeng.javaeedev.com");
        admin.setWebsite("http://www.javaeedev.com");
        admin.setProvince("北京市");
        admin.setCity("朝阳区");
        admin.setZip("100022");
        users.put(admin.getUsername(), admin);
    }

    public boolean isExist(String username) {
        return users.get(username)!=null;
    }

    public User query(String username) {
        if(users.get(username)==null)
            throw new RuntimeException("用户不存在");
        return users.get(username);
    }

    public void login(String username, String password) {
        User user = users.get(username);
        if(user==null)
            throw new RuntimeException("用户不存在");
        if(!user.getPassword().equals(password))
            throw new RuntimeException("口令错误");
    }

    public void register(User user) {
        if(users.get(user.getUsername())!=null)
            throw new RuntimeException("用户名已存在");
        users.put(user.getUsername(), user);
    }

    public void update(User user) {
        User u = users.get(user.getUsername());
        if(u==null)
            throw new RuntimeException("用户不存在");
        u.setEmail(user.getEmail());
        u.setBlog(user.getBlog());
        u.setWebsite(user.getWebsite());
        u.setProvince(user.getProvince());
        u.setCity(user.getCity());
        u.setZip(user.getZip());
    }

}
