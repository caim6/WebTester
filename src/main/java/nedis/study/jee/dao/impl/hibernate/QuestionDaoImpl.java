package nedis.study.jee.dao.impl.hibernate;

import nedis.study.jee.dao.QuestionDao;
import nedis.study.jee.entities.Question;
import nedis.study.jee.entities.Test;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by caim6 on 11.11.2015.
 */
@Repository("hibernateQuestionDao")
@SuppressWarnings("unchecked")
public class QuestionDaoImpl extends AbstractEntityDao<Question> implements QuestionDao {
    @Override
    protected Class<Question> getEntityClass() {
        return Question.class;
    }

    @Override
    public List<Question> getQuestionByTestId(Test test) {
        return getSession().createCriteria(getEntityClass()).add(Restrictions.eq("test", test)).list();
    }

    @Override
    public long getActiveQuestionCount(long idTest) {
        return (long) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("test.idTest",
                idTest)).add(Restrictions.eq("active", true)).setProjection(Projections.rowCount()).uniqueResult();
    }
    @Override
    public List<Question> getActiveQuestionListOfTest(long idTest, int offset, int count) {
        return getSession().createCriteria(getEntityClass()).add(Restrictions.eq("test.idTest", idTest)).
                add(Restrictions.eq("active", true)).addOrder(Order.asc("created")).setFirstResult(offset)
                .setMaxResults(count).list();
    }
}
