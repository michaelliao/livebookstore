package example.chapter7;

public interface UserService {

    boolean isExist(String username);

    void login(String username, String password);

    void register(User user);

    User query(String username);

    void update(User user);

}
