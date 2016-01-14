package caim.study.jee.dao.impl.hibernate;

import caim.study.jee.entities.Account;
import caim.study.jee.dao.TestResultDao;
import caim.study.jee.entities.TestResult;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateTestResultDao")
@SuppressWarnings("unchecked")
public class TestResultDaoImpl extends AbstractEntityDao<TestResult> implements TestResultDao {
    @Override
    protected Class<TestResult> getEntityClass() {
        return TestResult.class;
    }
    @Override
    public List<TestResult> getUserResults(Account account) {
        return (List<TestResult>) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("account", account))
                .addOrder(Order.desc("created")).list();
    }
}
