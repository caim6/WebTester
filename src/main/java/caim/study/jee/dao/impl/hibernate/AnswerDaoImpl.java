package caim.study.jee.dao.impl.hibernate;

import caim.study.jee.entities.Answer;
import caim.study.jee.dao.AnswerDao;
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
