package caim.study.jee.forms;

/**
 * Created by caim6 on 30.11.2015.
 */
public class UserForm extends AbstractLoginForm implements IForm {
    private static final long serialVersionUID = -3633827335080843887L;

    private String email;
    private String name;
    private String hash;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
