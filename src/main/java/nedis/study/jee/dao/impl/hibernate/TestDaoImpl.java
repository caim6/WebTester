package nedis.study.jee.dao.impl.hibernate;

import nedis.study.jee.dao.TestDao;
import nedis.study.jee.entities.Test;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by caim6 on 08.11.2015.
 */
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
