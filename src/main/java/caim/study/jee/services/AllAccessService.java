package caim.study.jee.services;

import caim.study.jee.entities.Account;
import caim.study.jee.forms.UserForm;


public interface AllAccessService {
    public void copyFormToUser(UserForm form, Account account);
}
