package nedis.study.jee.dao.impl.hibernate;

import nedis.study.jee.dao.AnswerDao;
import nedis.study.jee.entities.Answer;
import org.springframework.stereotype.Repository;

/**
 * Created by caim6 on 11.11.2015.
 */
@Repository("hibernateAnswerDao")
@SuppressWarnings("unchecked")
public class AnswerDaoImpl extends AbstractEntityDao<Answer> implements AnswerDao {
    @Override
    protected Class<Answer> getEntityClass() {
        return Answer.class;
    }

}
