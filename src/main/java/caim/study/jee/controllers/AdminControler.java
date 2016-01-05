package caim.study.jee.controllers;

import caim.study.jee.entities.Account;
import caim.study.jee.forms.admin.AdminForm;
import caim.study.jee.forms.UserForm;
import caim.study.jee.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminControler extends AbstractController {

    @Autowired
    protected AdminService adminService;

    @Autowired
    @Qualifier("loginFormValidator")
    private Validator validator;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        return "admin/home";
    }

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public String showTest(Model model) {
        model.addAttribute("users", adminService.loadAllUser());
        return "admin/listUsers";
    }

    @RequestMapping(value = "/id{userId}", method = RequestMethod.GET)
    public String showLogin(Model model, @PathVariable String userId) {
        Account user = adminService.getAccount(Long.valueOf(userId));
        AdminForm adminForm = adminService.getAdminForm(model, user);
        model.addAttribute("adminForm", adminForm);
        model.addAttribute("userId", userId);
        return "admin/userInfo";
    }
    @RequestMapping(value="/id{userId}", method= RequestMethod.POST)
    public String saveUser(Model model, @Validated @ModelAttribute("adminForm") AdminForm form, @PathVariable String userId){
        adminService.updateUser(Long.valueOf(userId), form);
        return "redirect:" +"/admin/listUsers";
    }

    @RequestMapping(value = "add/new/user", method = RequestMethod.GET)
    public String showLogin(Model model) {
        AdminForm adminForm = new AdminForm();
        model.addAttribute("adminForm", adminForm);
        return "admin/newUser";
    }

    @RequestMapping(value = "add/new/user", method = RequestMethod.POST)
    public String addUser(Model model,@ModelAttribute("userForm") UserForm form ) {
        commonService.addAccount(form);
        return "redirect:" +"/admin/listUsers";
    }

    @RequestMapping(value = "/delete/user/id{userId}")
    public String doDeleteInfo(Model model, @PathVariable Long userId) {
        adminService.deleteUser(userId);
        return "redirect:"+"/admin/listUsers";
    }

    @RequestMapping(value="/allAccess/info", method= RequestMethod.GET)
    public String showInfo(Model model,HttpSession session){
        Account account = commonService.getLoginAccount();
        model.addAttribute("account",account);
        return "admin/info";
    }

    @RequestMapping(value="/allAccess/editInfo", method=RequestMethod.GET)
    public String showEditInfo(Model model,HttpSession session){
        AdminForm adminForm = new AdminForm();
        Account account = commonService.getLoginAccount();
        adminForm.setEmail(account.getEmail());
        adminForm.setLogin(account.getLogin());
        adminForm.setPassword(account.getPassword());
        adminForm.setName(account.getName());
        model.addAttribute("adminForm", adminForm);
        return "admin/editInfo";
    }

    @RequestMapping(value="/allAccess/editInfo", method=RequestMethod.POST)
    public String editInfo(Model model,HttpSession session, @ModelAttribute("adminForm") AdminForm form){
        Account account = commonService.getLoginAccount();
        adminService.copyFormToUser(form,account);
        commonService.updateAccount(account);
        return "redirect:"+"/admin/allAccess/info";
    }

}