package caim.study.jee.forms.admin;

import caim.study.jee.entities.Role;
import caim.study.jee.forms.UserForm;

import java.util.List;

public class AdminForm extends UserForm {
    private Boolean confirmed = false;
    private Boolean active = false;
    private List<String> checkRoles;
    private List<Role> allRoles;



    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<String> getCheckRoles() {
        return checkRoles;
    }

    public void setCheckRoles(List<String> checkRoles) {
        this.checkRoles = checkRoles;
    }

    public List<Role> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<Role> allRoles) {
        this.allRoles = allRoles;
    }
}
