package nedis.study.jee.forms;

/**
 * Created by caim6 on 10.12.2015.
 */
public class AnswerForm implements IForm {
    private Boolean correct = false;
    private String answer;


    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
