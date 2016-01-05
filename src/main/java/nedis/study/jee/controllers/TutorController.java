package nedis.study.jee.controllers;

import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.Answer;
import nedis.study.jee.entities.Question;
import nedis.study.jee.forms.AnswerForm;
import nedis.study.jee.forms.QuestionForm;
import nedis.study.jee.forms.TestForm;
import nedis.study.jee.forms.UserForm;
import nedis.study.jee.services.AllAccessService;
import nedis.study.jee.services.TutorService;
import nedis.study.jee.utils.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author nedis
 * @version 1.0
 */
@Controller
@RequestMapping("/tutor")
public class TutorController extends AbstractTutorController {

    @Autowired
    private TutorService tutorService;
    @Autowired
    private AllAccessService allAccessService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "tutor/home";
    }

    @RequestMapping(value = "/testsList", method = RequestMethod.GET)
    public String showTutorTests(Model model) {
        Account account = commonService.getLoginAccount();
        model.addAttribute("tests", tutorService.getTestList(account));
        return "tutor/testsList";
    }

    @RequestMapping(value = "/allAccess/info", method = RequestMethod.GET)
    public String showInfo(Model model, HttpSession session) {
        Account account = commonService.getLoginAccount();
        model.addAttribute("account", account);
        return "tutor/info";
    }
    @RequestMapping(value = "/allAccess/editInfo", method = RequestMethod.GET)
    public String showEditInfo(Model model, HttpSession session) {
        UserForm userForm = new UserForm();
        Account account = commonService.getLoginAccount();
        ReflectionUtils.copyByFields(userForm, account);
        model.addAttribute("userForm", userForm);
        return "tutor/editInfo";
    }
    @RequestMapping(value = "/allAccess/editInfo", method = RequestMethod.POST)
    public String EditInfo(Model model, HttpSession session, @ModelAttribute("userForm") UserForm form) {
        Account account = commonService.getLoginAccount();
        allAccessService.copyFormToUser(form, account);
        commonService.updateAccount(account);
        return "redirect:" + "/tutor/allAccess/info";
    }

    @RequestMapping(value = "/newTest", method = RequestMethod.GET)
    public String showNewTest(Model model) {
        TestForm testForm = new TestForm();
        model.addAttribute("testForm", testForm);
        return "tutor/newTest";
    }

    @RequestMapping(value = "/newTest", method = RequestMethod.POST)
    public String addNewTest(@ModelAttribute("testForm") TestForm testform) {
        tutorService.createTest(testform);
        return "redirect:" + "/tutor/testsList";
    }

    @RequestMapping(value = "/delete/test/id{testId}")
    public String deleteTest(Model model, @PathVariable String testId) {
        tutorService.deleteTest(testId);
        return "redirect:" + "/tutor/testsList";
    }

    @RequestMapping(value = "/editQuestion/id{questionId}", method = RequestMethod.GET)
    public String showQuestion(Model model, @PathVariable String questionId) {
        QuestionForm questionForm = new QuestionForm();
        Question question = tutorService.getQuestion(questionId);
        questionForm.setName(question.getQuestion());
        model.addAttribute("questionId", questionId);
        model.addAttribute("answers", question.getAnswers());
        model.addAttribute("questionForm", questionForm);
        return "tutor/editQuestion";
    }

    @RequestMapping(value = "/edit/question/id{questionId}", method = RequestMethod.GET)
    public String editQuestion(Model model, @PathVariable String questionId, @ModelAttribute("questionForm") QuestionForm form) {
        QuestionForm questionForm = new QuestionForm();
        Question question = tutorService.getQuestion(questionId);
        model.addAttribute("questionForm", questionForm);
        questionForm.setName(question.getQuestion());
        return "tutor/newQuestion";
    }

    @RequestMapping(value = "/edit/question/id{questionId}", method = RequestMethod.POST)
    public String saveQuestion(Model model, @PathVariable String questionId, @ModelAttribute("questionForm") QuestionForm form) {
        tutorService.updateQuestion(questionId, form);
        return "redirect:" + "/tutor/editQuestion/id{questionId}";
    }

    @RequestMapping(value = "/newQuestion/id{testId}", method = RequestMethod.GET)
    public String getNewQuestion(Model model, @PathVariable String testId) {
        QuestionForm questionForm = new QuestionForm();
        model.addAttribute("questionForm", questionForm);
        model.addAttribute("testId", testId);
        return "tutor/newQuestion";
    }

    @RequestMapping(value = "/newQuestion/id{testId}", method = RequestMethod.POST)
    public String editNewQuestion(Model model, @PathVariable String testId, @ModelAttribute("questionForm") QuestionForm form) {
        tutorService.createQuestion(form, testId);
        return "redirect:" + "/tutor/questions/id{testId}";
    }

    @RequestMapping(value = "/delete/question/id{questionId}/{testId}")
    public String deleteQuestion(@PathVariable String questionId, @PathVariable String testId) {
        tutorService.deleteQuestion(questionId);
        return "redirect:" + "/tutor/questions/id{testId}";
    }

    @RequestMapping(value = "/questions/id{testId}", method = RequestMethod.GET)
    public String showQuestionsByTestId(Model model, @PathVariable String testId) {
        model.addAttribute("questions", tutorService.getQuestionByTestId(testId));
        model.addAttribute("test", tutorService.getTest(testId));
        return "tutor/questions";
    }

    @RequestMapping(value = "/delete/answer/id{answerId}/{questionId}")
    public String deleteAnswer(@PathVariable String answerId, @PathVariable String questionId) {
        tutorService.deleteAnswer(answerId);
        return "redirect:" + "/tutor/editQuestion/id{questionId}";
    }

    @RequestMapping(value = "/edit/answer/id{answerId}/{questionId}", method = RequestMethod.GET)
    public String editAnswer(@PathVariable String answerId, @PathVariable String questionId, Model model) {
        AnswerForm answerForm = new AnswerForm();
        Answer answer = tutorService.getAnswer(answerId);
        answerForm.setAnswer(answer.getAnswer());
        model.addAttribute("answerForm", answerForm);
        model.addAttribute("questionId", questionId);
        return "tutor/editAnswer";
    }

    @RequestMapping(value = "/edit/answer/id{answerId}/{questionId}", method = RequestMethod.POST)
    public String editAnswer(@PathVariable String answerId, Model model, @PathVariable String questionId, @ModelAttribute("answerForm") AnswerForm answerForm) {
        tutorService.updateAnswer(answerId, answerForm);
        return "redirect:" + "/tutor/editQuestion/id{questionId}";
    }

    @RequestMapping(value = "/edit/new/answer/id{questionId}", method = RequestMethod.GET)
    public String ediNewtAnswer(@PathVariable String questionId, Model model) {
        AnswerForm answerForm = new AnswerForm();
        model.addAttribute("answerForm", answerForm);
        model.addAttribute("questionId", questionId);
        return "tutor/editAnswer";
    }

    @RequestMapping(value = "/edit/new/answer/id{questionId}", method = RequestMethod.POST)
    public String editNewtAnswer(@PathVariable String questionId, Model model, @ModelAttribute("answerForm") AnswerForm answerForm) {
        tutorService.createAnswer(answerForm, questionId);
        return "redirect:" + "/tutor/editQuestion/id{questionId}";
    }
}
