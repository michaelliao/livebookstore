package example.chapter8;

public interface UserService {

    User login(String username, String password);

    void create(String username, String password);

}
