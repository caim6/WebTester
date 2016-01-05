package nedis.study.jee.dao;

import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.TestResult;

import java.util.List;

/**
 * Created by caim6 on 11.11.2015.
 */
public interface TestResultDao extends IEntityDao<TestResult> {
    List<TestResult> getUserResults(Account account);
}
