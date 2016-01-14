package caim.study.jee.forms;


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
