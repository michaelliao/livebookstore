package example.chapter7.struts;

import org.apache.struts.action.Action;

import example.chapter7.UserService;
import example.chapter7.UserServiceImpl;

public class BaseAction extends Action {

    private static final UserService userService = new UserServiceImpl();

    public UserService getUserService() {
        return userService;
    }
}
