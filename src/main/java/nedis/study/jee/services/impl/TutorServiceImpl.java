package nedis.study.jee.services.impl;

import nedis.study.jee.components.EntityBuilder;
import nedis.study.jee.dao.AccountDao;
import nedis.study.jee.dao.AnswerDao;
import nedis.study.jee.dao.QuestionDao;
import nedis.study.jee.dao.TestDao;
import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.Answer;
import nedis.study.jee.entities.Question;
import nedis.study.jee.entities.Test;
import nedis.study.jee.forms.AnswerForm;
import nedis.study.jee.forms.QuestionForm;
import nedis.study.jee.forms.TestForm;
import nedis.study.jee.services.CommonService;
import nedis.study.jee.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
@Service
public class TutorServiceImpl implements TutorService {
    @Autowired
    CommonService commonService;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AccountDao accountDao;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    private TestDao testDao;
    @Autowired
    private AnswerDao answerDao;

    @Override
    public List<Test> getTestList(Account account) {
        return accountDao.getListTest(account);
    }

    @Override
    @Transactional
    public void createTest(TestForm form) {
        Test newTest = entityBuilder.buildTest();
        newTest.setTitle(form.getTitle());
        newTest.setPeriodPerQuestion(form.getPeriodPerQuestion());
        newTest.setDescription(form.getDescription());
        Account account = commonService.getLoginAccount();
        newTest.setAccount(account);
        testDao.save(newTest);
    }

    @Override
    public Test getTest(String testId) {
        return testDao.findById(Long.valueOf(testId));
    }

    @Override
    public Answer getAnswer(String answerId) {
        return answerDao.findById(Long.valueOf(answerId));
    }

    @Override
    public Question getQuestion(String questionId) {
        return questionDao.findById(Long.valueOf(questionId));
    }

    @Override
    @Transactional
    public void deleteQuestion(String questionId) {
        questionDao.delete(questionDao.findById(Long.valueOf(questionId)));
    }

    @Override
    public List<Question> getQuestionByTestId(String testId) {
        Test test = testDao.findById(Long.valueOf(testId));
        return questionDao.getQuestionByTestId(test);
    }


    @Override
    @Transactional
    public void createQuestion(QuestionForm form, String testId) {
        Question question = entityBuilder.buildQuestion();
        question.setQuestion(form.getName());
        Test test = testDao.findById(Long.valueOf(testId));
        question.setTest(test);
        questionDao.save(question);
    }

    @Override
    @Transactional
    public void createAnswer(AnswerForm form, String questionId) {
        Answer answer = entityBuilder.buildAnswer();
        answer.setAnswer(form.getAnswer());
        answer.setCorrect(form.getCorrect());
        Question question = questionDao.findById(Long.valueOf(questionId));
        answer.setQuestion(question);
        answerDao.save(answer);
    }

    @Override
    @Transactional
    public void updateQuestion(String questionId, QuestionForm form) {
        Question question = questionDao.findById(Long.valueOf(questionId));
        question.setQuestion(form.getName());
        questionDao.update(question);
    }

    @Override
    @Transactional
    public void updateAnswer(String answerId, AnswerForm form) {
        Answer answer = answerDao.findById(Long.valueOf(answerId));
        answer.setAnswer(form.getAnswer());
        answer.setCorrect(form.getCorrect());
        answerDao.update(answer);
    }

    @Override
    @Transactional
    public void deleteTest(String testId) {
        testDao.delete(testDao.findById(Long.valueOf(testId)));
    }

    @Override
    @Transactional
    public void deleteAnswer(String answerId) {
        answerDao.delete(answerDao.findById(Long.valueOf(answerId)));
    }
}
