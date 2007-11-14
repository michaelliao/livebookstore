package example.chapter7.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        username = null;
        password = null;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest reqeust) {
        ActionErrors errors = new ActionErrors();
        if(username==null || username.equals(""))
            errors.add("username", new ActionMessage("errors.username"));
        if(password==null || password.equals(""))
            errors.add("password", new ActionMessage("errors.password"));
        return errors;
    }
}
