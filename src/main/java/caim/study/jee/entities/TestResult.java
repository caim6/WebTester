package caim.study.jee.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by caim6 on 11.11.2015.
 */

@Entity
@Table(name = "test_result", schema = "xgbua_web_tester")
public class TestResult {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TESTRESULT_ID_GENERATOR", sequenceName = "TEST_RESULT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TESTRESULT_ID_GENERATOR")
    @Column(name = "id_test_result", unique = true, nullable = false)
    private Long testResult;

    @Column(name = "correct_count", nullable = false)
    private Long correctCount;

    @Column(name = "all_count", nullable = false)
    private long allCount;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "test_name", nullable = false)
    private String testName;

    @OneToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;

    @OneToOne
    @JoinColumn(name = "id_test", nullable = false)
    private Test test;

    public TestResult() {
    }

    public Long getTestResult() {
        return testResult;
    }

    public void setTestResult(Long testResult) {
        this.testResult = testResult;
    }

    public Long getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Long correctCount) {
        this.correctCount = correctCount;
    }

    public long getAllCount() {
        return allCount;
    }

    public void setAllCount(long allCount) {
        this.allCount = allCount;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
