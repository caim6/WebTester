package caim.study.jee.dao.impl.hibernate;

import caim.study.jee.dao.TestDao;
import caim.study.jee.entities.Test;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateTestDao")
@SuppressWarnings("unchecked")
public class TestDaoImpl extends AbstractEntityDao<Test> implements TestDao {


    @Override
    protected Class<Test> getEntityClass() {
        return Test.class;
    }

    @Override
    public List<Test> getTestList(Integer offset, Integer count) {
        return (List<Test>) getSession().createCriteria(Test.class)
                .setFirstResult(offset)
                .setMaxResults(count)
                .list();
    }
    @Override
    public Long getAllTestsCount() {
        return (Long) getSession().createCriteria(getEntityClass())
                .setProjection(Projections.rowCount()).uniqueResult();
    }
}
