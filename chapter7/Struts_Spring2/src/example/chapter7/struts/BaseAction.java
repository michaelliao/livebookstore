package example.chapter7.struts;

import org.apache.struts.action.Action;

import example.chapter7.UserService;

public class BaseAction extends Action {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
