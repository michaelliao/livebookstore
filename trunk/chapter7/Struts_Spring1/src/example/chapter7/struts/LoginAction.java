package example.chapter7.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import example.chapter7.User;

public class LoginAction extends BaseAction {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm)form;
        try {
            User user = getUserService().login(loginForm.getUsername(), loginForm.getPassword());
            request.getSession().setAttribute("username", user.getUsername());
            return mapping.findForward("success");
        }
        catch(Exception e) {
            ActionMessages msgs = new ActionMessages();
            msgs.add("loginfailed", new ActionMessage("errors.login.failed"));
            addErrors(request, msgs);
            return mapping.findForward("failure");
        }
    }

}
