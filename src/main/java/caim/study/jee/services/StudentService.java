package caim.study.jee.services;

import caim.study.jee.entities.Account;
import caim.study.jee.entities.Test;
import caim.study.jee.entities.Question;
import caim.study.jee.entities.TestResult;

import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
public interface StudentService {

    List<Test> listAllTests(int page, int count);

    int getMaxPageTests(Integer count);

    List<TestResult> listAllResult(Account account);

    TestResult prepareTestResult(long idAccount, Long idTest);

    Question getQuestion(long idTest, long question);

    TestResult checkAnswers(List<String> answerIds, Question question, TestResult testResult);

    void saveTestResult(TestResult testResult);
}
