package nedis.study.jee.services;

import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.Answer;
import nedis.study.jee.entities.Question;
import nedis.study.jee.entities.Test;
import nedis.study.jee.forms.AnswerForm;
import nedis.study.jee.forms.QuestionForm;
import nedis.study.jee.forms.TestForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
public interface TutorService {
    List<Test> getTestList(Account account);

    @Transactional
    void createTest(TestForm form);

    Test getTest(String testId);

    Answer getAnswer(String answerId);

    Question getQuestion(String questionId);

    @Transactional
    void deleteQuestion(String questionId);

    List<Question> getQuestionByTestId(String testId);

    @Transactional
    void createQuestion(QuestionForm form, String testId);


    @Transactional
    void createAnswer(AnswerForm form, String questionId);

    @Transactional
    void updateQuestion(String questionId, QuestionForm form);

    @Transactional
    void updateAnswer(String answerId, AnswerForm form);

    @Transactional
    void deleteTest(String testId);

    @Transactional
    void deleteAnswer(String answerId);
}
