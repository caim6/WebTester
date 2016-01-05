package nedis.study.jee.forms;


import nedis.study.jee.entities.Account;

/**
 * @author nedis
 * @version 1.0
 */
public class SignUpForm extends AbstractLoginForm implements IForm {
    private static final long serialVersionUID = -3633827335080843887L;

    private String password2;

    private String email;

    private String name;


    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

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

    public void copyFieldsTo(Account account) {
        account.setEmail(email);
        account.setLogin(super.getLogin());
        account.setPassword(password2);
        account.setName(name);
    }

}
