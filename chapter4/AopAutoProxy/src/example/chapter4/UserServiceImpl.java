package example.chapter4;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(String username, String password) {
        userDao.create(username, password);
    }

    public void login(String username, String password) {
        userDao.login(username, password);
    }

}
