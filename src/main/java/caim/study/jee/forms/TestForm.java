package caim.study.jee.forms;

public class TestForm implements IForm {
    private String title;
    private String description;
    private int periodPerQuestion;



    public int getPeriodPerQuestion() {
        return periodPerQuestion;
    }

    public void setPeriodPerQuestion(int periodPerQuestion) {
        this.periodPerQuestion = periodPerQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
