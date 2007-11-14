package example.chapter7.struts;

import org.springframework.web.struts.ActionSupport;

import example.chapter7.UserService;

public class BaseAction extends ActionSupport {

    public UserService getUserService() {
        return (UserService)getWebApplicationContext().getBean("userService");
    }
}
