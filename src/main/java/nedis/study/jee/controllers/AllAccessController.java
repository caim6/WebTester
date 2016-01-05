package nedis.study.jee.controllers;

import nedis.study.jee.entities.Account;
import nedis.study.jee.services.StudentService;
import nedis.study.jee.services.impl.AllAccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by caim6 on 06.12.2015.
 */
@Controller
public class AllAccessController extends AbstractController {
    @Autowired
    protected StudentService studentService;

    @Autowired
    protected AllAccessServiceImpl allAccessService;

    @RequestMapping(value = "/allAccess/info", method = RequestMethod.GET)
    public String showInfo(Model model, HttpSession session) {
        Account account = commonService.getLoginAccount();
        model.addAttribute("account", account);
        return "allAccess/info";
    }


}
