package example.chapter7;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String email = ((String)value).trim();
        if(!email.matches("[a-zA-Z0-9][\\w\\.\\-]*@[a-zA-Z0-9][\\w\\.\\-]*\\.[a-zA-Z][a-zA-Z\\.]*")) {
            throw new ValidatorException(
                    new FacesMessage("Invalid email address"));
        }
    }

}
