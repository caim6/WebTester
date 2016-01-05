package caim.study.jee.controllers;

import caim.study.jee.ApplicationConstants;
import caim.study.jee.entities.Account;
import caim.study.jee.entities.Role;
import caim.study.jee.exceptions.InvalidUserInputException;
import caim.study.jee.forms.LoginForm;
import caim.study.jee.forms.SignUpForm;
import caim.study.jee.forms.UserForm;
import caim.study.jee.security.CurrentAccount;
import caim.study.jee.security.SecurityUtils;
import caim.study.jee.services.CommonService;
import caim.study.jee.services.SignUpService;
import caim.study.jee.services.impl.TemplateServiceImpl;
import caim.study.jee.utils.ReflectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nedis
 * @version 1.0
 */
@Controller
public class CommonControler extends AbstractController implements InitializingBean {
    @Autowired
    protected SignUpService signUpService;
    @Autowired
    private TemplateServiceImpl templateService;
    private final Map<Integer, String> redirects = new HashMap<Integer, String>();

    @Override
    public void afterPropertiesSet() throws Exception {
        redirects.put(ApplicationConstants.ADMIN_ROLE, "/admin/home");
        redirects.put(ApplicationConstants.ADVANCED_TUTOR_ROLE, "/advanced_tutor/home");
        redirects.put(ApplicationConstants.TUTOR_ROLE, "/tutor/home");
        redirects.put(ApplicationConstants.STUDENT_ROLE, "/home");
    }

    @Autowired
    protected CommonService commonService;

    @Autowired
    @Qualifier("loginFormValidator")
    private Validator validator;

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }*/

    @RequestMapping(value = {"/login", "/url=/login"}, method = RequestMethod.POST)
    public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result,
                        Model model, HttpSession session) {
        try {
            if (result.hasErrors()) {
                initRoles(model);
                return "/myInfo";
            }
            Account a = commonService.login(loginForm.getLogin(), loginForm.getPassword(), loginForm.getIdRole());
            session.setAttribute("CURRENT_ACCOUNT", a);

            return "redirect:" + "/myInfo";
        } catch (InvalidUserInputException e) {
            result.addError(new ObjectError("", e.getMessage()));
            initRoles(model);
            return "/login";
        }
    }

    protected void initRoles(Model model) {
        List<Role> roles = commonService.listAllRoles();
        model.addAttribute("roles", roles);
    }


    @RequestMapping(value = {"/login", "/loginFailed"}, method = RequestMethod.GET)
    public String showLogin(Model model) {
        initRoles(model);
        return "login";
    }

    @RequestMapping(value = {"/myInfo"}, method = RequestMethod.GET)
    public String myInfo(Model model) {
        CurrentAccount currentAccount = SecurityUtils.getCurrentAccount();
        return "redirect:" + redirects.get(currentAccount.getRole());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showqLogin(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signup";
    }

    @RequestMapping(value = "/signup/hash{hashText}", method = RequestMethod.GET)
    public String DoConfirmRegister(Model model, @PathVariable String hashText) {
        Account account = signUpService.getAccountByHash(hashText);
        if (account == null) {
            model.addAttribute("confirmed", "Incorrect link");
        } else if (account.getConfirmed()) {
            model.addAttribute("confirmed", "Account already confirmed");
        } else {
            signUpService.confirmAccount(account);
            model.addAttribute("confirmed", "Congradulation account confirmed");
        }

        return "confirm";
    }

    @RequestMapping(value = "/signup/ok", method = RequestMethod.POST)
    public String doSignUp(Model model, @ModelAttribute("signUpForm") UserForm form, BindingResult result) throws InvalidUserInputException, javax.mail.MessagingException {
        try {
            commonService.signUp(form, true);
            model.addAttribute("confirmed", "Check email to confirm password");
            return "confirm";
        } catch (InvalidUserInputException e) {
            result.addError(new ObjectError("Can't create user. Change some information.", e.getMessage()));
            LOGGER.info("Input form Error " + e.getMessage());
            return "/signup";
        } catch (FileNotFoundException e) {
            result.addError(new ObjectError("Can't find e-mail template file.", e.getMessage()));
            LOGGER.info("Can't find e-mail template file " + e.getMessage());
            return "/signup";
        }

    }

    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public String showForget(Model model) {
        model.addAttribute("signUpForm", new UserForm());
        return "forget";
    }

    @RequestMapping(value = "/forgetOk", method = RequestMethod.POST)
    public String doForgetUp(Model model, @ModelAttribute("signUpForm") UserForm form, BindingResult result) throws InvalidUserInputException {
        Account account = signUpService.getAccountByEmail(form.getEmail());
        try {
            if (account != null) {
                ReflectionUtils.copyByFields(form, account);
                templateService.sendRestoreEmail(form);
                model.addAttribute("confirmed", "Check email");
            } else
                model.addAttribute("confirmed", "No email found");
            return "redirect:" + "/login";

        } catch (MessagingException e) {
            result.addError(new ObjectError("Can't send e-mail", e.getMessage()));
            LOGGER.info("send e-mail Error " + e.getMessage());
            return "redirect:forget";
        } catch (FileNotFoundException e) {
            result.addError(new ObjectError("Can't find e-mail template file.", e.getMessage()));
            LOGGER.info("Can't find e-mail template file " + e.getMessage());
            return "redirect:forget";
        }
    }


}
