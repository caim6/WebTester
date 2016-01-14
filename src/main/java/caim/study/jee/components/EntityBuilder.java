package caim.study.jee.components;

import caim.study.jee.entities.*;


public interface EntityBuilder {

    Account buildAccount();

    AccountRole buildAccountRole(Account account, Role role);

    TestResult buildTestResult(Account account, Test test);

    Test buildTest();

    Question buildQuestion();

    Answer buildAnswer();

    TestResult buildTestResults(TestResult result);

    TestResult buildTestResult(Account account, Test test, long allQuestions);
}
