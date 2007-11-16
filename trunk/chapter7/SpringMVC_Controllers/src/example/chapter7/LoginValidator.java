package example.chapter7;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @spring.bean id="loginValidator"
 */
public class LoginValidator implements Validator {

    public boolean supports(Class clazz) {
        return clazz==User.class;
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username.required", "必须填写用户名");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.password.required", "必须填写口令");
    }

}
