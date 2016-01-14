package caim.study.jee.dao;

import caim.study.jee.entities.Account;
import caim.study.jee.entities.TestResult;

import java.util.List;


public interface TestResultDao extends IEntityDao<TestResult> {
    List<TestResult> getUserResults(Account account);
}
