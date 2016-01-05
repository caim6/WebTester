package nedis.study.jee.forms;

import nedis.study.jee.entities.Answer;

import java.util.List;

/**
 * Created by caim6 on 06.12.2015.
 */
public class QuestionForm {
    private String name;
    private List<Answer> answers;


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}

