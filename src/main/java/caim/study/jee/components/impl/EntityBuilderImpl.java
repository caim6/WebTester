package caim.study.jee.components.impl;

import caim.study.jee.components.EntityBuilder;
import caim.study.jee.entities.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component("entityBuilder")
public class EntityBuilderImpl implements EntityBuilder {

    @Override
    public Account buildAccount() {
        Account a = new Account();
        a.setCreated(new Timestamp(System.currentTimeMillis()));
        //a.setUpdated(new Timestamp(System.currentTimeMillis()));
        a.setActive(Boolean.FALSE);
        a.setConfirmed(Boolean.FALSE);
        return a;
    }

    @Override
    public AccountRole buildAccountRole(Account account, Role role) {
        return new AccountRole(account, role);
    }

    @Override
    public TestResult buildTestResult(Account account, Test test) {
        TestResult testResult = new TestResult();
        testResult.setAccount(account);
        testResult.setTest(test);
        testResult.setCreated(new Timestamp(System.currentTimeMillis()));
        testResult.setTestName(test.getTitle());
        return testResult;
    }

    @Override
    public Test buildTest() {
        Test test = new Test();
        test.setCreated(new Timestamp(System.currentTimeMillis()));
        test.setActive(Boolean.TRUE);
        return test;
    }

    @Override
    public Question buildQuestion() {
        Question q = new Question();
        q.setCreated(new Timestamp(System.currentTimeMillis()));
        q.setActive(Boolean.TRUE);
        return q;
    }

    @Override
    public Answer buildAnswer() {
        Answer answer = new Answer();
        answer.setCreated(new Timestamp(System.currentTimeMillis()));
        answer.setActive(Boolean.TRUE);
        return answer;
    }

    @Override
    public TestResult buildTestResults(TestResult result) {
        TestResult testResult = new TestResult();
        testResult.setAccount(result.getAccount());
        testResult.setTest(result.getTest());
        testResult.setTestName(result.getTestName());
        testResult.setCorrectCount(result.getCorrectCount());
        testResult.setAllCount(result.getAllCount());
        testResult.setCreated(new Timestamp(System.currentTimeMillis()));
        return testResult;
    }
    @Override
    public TestResult buildTestResult(Account account, Test test, long allQuestions) {
        TestResult testResult = new TestResult();
        testResult.setAccount(account);
        testResult.setTest(test);
        testResult.setTestName(test.getTitle());
        testResult.setCorrectCount((long) 0);
        testResult.setAllCount(allQuestions);
        return testResult;
    }

}
