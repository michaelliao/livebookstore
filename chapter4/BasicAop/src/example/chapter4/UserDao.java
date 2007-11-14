package example.chapter4;

import java.util.*;

public class UserDao {

    private Map<String, String> map = new HashMap<String, String>();

    public UserDao() {
        map.put("admin", "security");
        map.put("test", "123456");
    }

    public void create(String username, String password) {
        if(map.get(username)!=null)
            throw new RuntimeException("User exist!");
        map.put(username, password);
    }

    public void login(String username, String password) {
        String pw = map.get(username);
        if(pw==null || !pw.equals(password))
            throw new RuntimeException("Login failed.");
    }

    public void print() {
        System.out.println("User list:");
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            System.out.println(key);
        }
    }
}
