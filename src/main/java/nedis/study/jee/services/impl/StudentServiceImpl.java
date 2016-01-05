package nedis.study.jee.services.impl;

import nedis.study.jee.components.EntityBuilder;
import nedis.study.jee.dao.AccountDao;
import nedis.study.jee.dao.QuestionDao;
import nedis.study.jee.dao.TestDao;
import nedis.study.jee.dao.TestResultDao;
import nedis.study.jee.entities.*;
import nedis.study.jee.services.CommonService;
import nedis.study.jee.services.StudentService;
import nedis.study.jee.utils.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StudentServiceImpl implements StudentService {
    @Autowired
    protected CommonService commonService;
    @Autowired
    @Qualifier("hibernateTestDao")
    private TestDao testDao;

    @Autowired
    @Qualifier("hibernateQuestionDao")
    private QuestionDao questionDao;

    @Autowired
    @Qualifier("hibernateTestResultDao")
    private TestResultDao testResultDao;

    @Autowired
    @Qualifier("hibernateAccountDao")
    private AccountDao accountDao;

    @Autowired
    @Qualifier("entityBuilder")
    private EntityBuilder entityBuilder;
    @Override
    public List<Test> listAllTests(int page, int count) {
        return testDao.getTestList((page - 1) * count, count);
    }
    @Override
    public int getMaxPageTests(Integer count) {
        return Calculation.getMaxPage(testDao.getAllTestsCount(), count);
    }
    @Override
    public List<TestResult> listAllResult(Account account) {
        return testResultDao.getUserResults(account);
    }


    @Override
    public TestResult prepareTestResult(long idAccount, Long id) {
        Account account = accountDao.findById(idAccount);
        Test test = testDao.findById(id);
        long allQuestions = questionDao.getActiveQuestionCount(id);
        TestResult testResult = entityBuilder.buildTestResult(account, test, allQuestions);
        return testResult;
    }

    @Override
    public Question getQuestion(long idTest, long question) {
        long a = question;
        int anInt = new BigDecimal(a).intValueExact();
        return questionDao.getActiveQuestionListOfTest(idTest, anInt, 1).get(0);
    }

    @Override
    public TestResult checkAnswers(List<String> answerIds, Question question, TestResult testResult) {
        if (answerIds == null) {
            return testResult;
        }
        List<Answer> answers = question.getAnswers();
        for (String answerId : answerIds) {
            for (Answer answer : answers) {
                if (answer.getIdAnswer().equals(Long.parseLong(answerId)) && !answer.getCorrect()) {
                    return testResult;
                }
            }
        }
        int correctCount = 0;
        for (Answer answer : answers) {
            if (answer.getCorrect()) {
                correctCount++;
            }
        }
        if (correctCount == answerIds.size()) {
            testResult.setCorrectCount(testResult.getCorrectCount() + 1);
        }
        return testResult;
    }

    @Override
    @Transactional
    public void saveTestResult(TestResult testResult) {
        TestResult a = entityBuilder.buildTestResults(testResult);
        testResultDao.save(a);
    }

}