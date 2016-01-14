package caim.study.jee.forms;

import caim.study.jee.entities.Answer;

import java.util.List;

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

