package nedis.study.jee.controllers;

import nedis.study.jee.ApplicationConstants;
import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.Question;
import nedis.study.jee.entities.Test;
import nedis.study.jee.entities.TestResult;
import nedis.study.jee.forms.UserForm;
import nedis.study.jee.security.SecurityUtils;
import nedis.study.jee.services.CommonService;
import nedis.study.jee.services.StudentService;
import nedis.study.jee.utils.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
@Controller
public class StudentController extends AbstractController {
    @Autowired
    protected CommonService commonService;
    @Autowired
    protected StudentService studentService;

    protected void initTests(Model model, int page, int count) {
        List<Test> tests = studentService.listAllTests(page, count);
        model.addAttribute("tests", tests);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showStudent() {
        return "student/home";
    }

    @RequestMapping(value = "/student/allAccess/info", method = RequestMethod.GET)
    public String showInfo(Model model, HttpSession session) {
        Account account = commonService.getLoginAccount();
        model.addAttribute("account", account);
        return "student/info";
    }

    @RequestMapping(value = "/student/allAccess/editInfo", method = RequestMethod.GET)
    public String showwEditInfo(Model model, HttpSession session) {
        UserForm userForm = new UserForm();
        Account account = commonService.getLoginAccount();
        ReflectionUtils.copyByFields(userForm, account);
        model.addAttribute("userForm", userForm);
        return "student/editInfo";
    }

    @RequestMapping(value = "/student/allAccess/editInfo", method = RequestMethod.POST)
    public String EditInfo(Model model, HttpSession session, @ModelAttribute("userForm") UserForm form) {

        Account account = commonService.getLoginAccount();
        allAccessService.copyFormToUser(form, account);
        commonService.updateAccount(account);
        return "redirect:" + "/student/allAccess/info";
    }
    private void deleteValuesFromSession(HttpSession session) {
        if (session.getAttribute("idTest") != null) {
            session.removeAttribute("idTest");
        }
        if (session.getAttribute("testResult") != null) {
            session.removeAttribute("testResult");
        }
        if (session.getAttribute("question") != null) {
            session.removeAttribute("question");
        }
        if (session.getAttribute("questionNumber") != null) {
            session.removeAttribute("questionNumber");
        }
        if (session.getAttribute("maxQuestions") != null) {
            session.removeAttribute("maxQuestions");
        }
    }
    @RequestMapping(value="/student/allAccess/result", method= RequestMethod.GET)
    public String showResults(Model model,HttpSession session){
        Account account = commonService.getLoginAccount();
        model.addAttribute("results",studentService.listAllResult(account));
        return "allAccess/result";
    }
    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public String showTest(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                           @RequestParam(value = "count", required = false, defaultValue = ApplicationConstants.DEFAULT_PAGE_COUNT) Integer count,
                           Model model, HttpSession session) {
        deleteValuesFromSession(session);
        initTests(model, page, count);
        model.addAttribute("mode", "online");
        model.addAttribute("maxPages", studentService.getMaxPageTests(count));
        model.addAttribute("page", page);
        return "student/tests";
    }

    @RequestMapping(value = "/pass-test/id{id}", method = RequestMethod.GET)
    public String prepareToTestPassing(@PathVariable long id, HttpSession session) {
        TestResult testResult = studentService.prepareTestResult((int) SecurityUtils.getCurrentIdAccount(), id);
        session.setAttribute("testResult", testResult);
        session.setAttribute("idTest", id);
        session.setAttribute("questionNumber", 0L);
        session.setAttribute("maxQuestions", (testResult.getAllCount()));
        return "redirect:"+"/student/passing-test";
    }
    @RequestMapping(value = "/student/passing-test", method = RequestMethod.GET)
    public String showQuestions(Model model, HttpSession session) {
        if ((long) session.getAttribute("questionNumber") == (long) session.getAttribute("maxQuestions")) {
            return "redirect:/student/test-result";
        }
        Question question = studentService.getQuestion((long) session.getAttribute("idTest"),
                (long) session.getAttribute("questionNumber"));
        session.setAttribute("question", question);
        model.addAttribute("question", question);
        return "student/question";
    }
    @RequestMapping(value = "/student/passing-test", method = RequestMethod.POST)
    public String nextQuestion(@RequestParam(value = "answer", required = false) List<String> answerIds, HttpSession
            session) {
        session.setAttribute("questionNumber", ((long) session.getAttribute("questionNumber") + 1));
        TestResult testResult = studentService.checkAnswers(answerIds, (Question) session.getAttribute("question"),
                (TestResult) session.getAttribute("testResult"));
        session.setAttribute("testResult", testResult);
        return "redirect:"+ "/student/passing-test";
    }

    @RequestMapping(value = "/student/test-result", method = RequestMethod.GET)
    public String showTestResult(Model model, HttpSession session) {
        TestResult testResult = (TestResult) session.getAttribute("testResult");
        studentService.saveTestResult(testResult);
        model.addAttribute("testResult", testResult);
        deleteValuesFromSession(session);
        return "student/result";
    }




}
