package caim.study.jee.components.impl;

import caim.study.jee.forms.SignUpForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by caim6 on 28.11.2015.
 */
@Component("signUpFormValidator")
public class SignUpFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpForm.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "password2.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "fio.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");

    }
}
