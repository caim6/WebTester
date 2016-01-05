package caim.study.jee.dao;

import caim.study.jee.entities.Test;
import caim.study.jee.entities.Question;

import java.util.List;

/**
 * Created by caim6 on 08.11.2015.
 */
public interface QuestionDao extends IEntityDao<Question> {

    List<Question> getQuestionByTestId(Test test);

    long getActiveQuestionCount(long idTest);

    List<Question> getActiveQuestionListOfTest(long idTest, int offset, int count);
}
