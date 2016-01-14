package caim.study.jee.services;

import caim.study.jee.entities.Account;
import caim.study.jee.entities.Answer;
import caim.study.jee.entities.Test;
import caim.study.jee.forms.AnswerForm;
import caim.study.jee.forms.QuestionForm;
import caim.study.jee.forms.TestForm;
import caim.study.jee.entities.Question;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
