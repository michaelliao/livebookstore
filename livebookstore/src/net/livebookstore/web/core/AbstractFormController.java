package net.livebookstore.web.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.livebookstore.util.HttpUtil;

import org.springframework.web.servlet.ModelAndView;

/**
 * AbstractFormController that binds object to http form.
 * 
 * @author Xuefeng
 */
public abstract class AbstractFormController extends AbstractBaseController {

    private Class clazz;

    public AbstractFormController() {
        this.clazz = getEmptyFormObject().getClass();
    }

    public final ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();
        if(method.equals("GET")) {
            Map model = new HashMap();
            model.put("form", getEmptyFormObject());
            return new ModelAndView(getFormView(request), model);
        }
        else if(method.equals("POST")) {
            Object form = HttpUtil.createFormBean(request, clazz);
            try {
                List<String> errors = new ArrayList<String>(3);
                validate(errors, form);
                if(errors.isEmpty()) {
                    doSubmit(form);
                    response.sendRedirect(getSuccessView(request));
                }
                else {
                    Map model = new HashMap();
                    model.put("form", form);
                    model.put("errors", errors);
                    return new ModelAndView(getFormView(request), model);
                }
            }
            catch(Exception e) {
                // display error:
                String error = convertException(e);
                Map model = new HashMap();
                model.put("error", error==null ? "未知错误" : error);
                model.put("form", form);
                return new ModelAndView(getFormView(request), model);
            }
            return null;
        }
        // not GET or POST:
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return null;
    }

    /**
     * Return form view, e.g.: "register-form.html".
     * 
     * @return The form view.
     */
    protected abstract String getFormView(HttpServletRequest request);

    /**
     * Return a success view after submitting a form successfully.
     * 
     * @return A success view, e.g.: "register-success.html".
     */
    protected abstract String getSuccessView(HttpServletRequest request);

    /**
     * Create an empty form-object to initalize the form.
     * 
     * @return The empty or default form object.
     */
    protected abstract Object getEmptyFormObject();

    /**
     * Do submit action.
     * 
     * @param obj The form object that has binded form data.
     */
    protected abstract void doSubmit(Object form);

    /**
     * Convert exception to String message.
     * 
     * @param e
     * @return
     */
    protected abstract String convertException(Exception e);

    /**
     * Validate form object.
     * 
     * @param errors
     * @param form
     */
    protected abstract void validate(List<String> errors, Object form);

}
