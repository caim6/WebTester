package caim.study.jee.services;

import caim.study.jee.entities.Account;
import caim.study.jee.forms.UserForm;

/**
 * Created by caim6 on 06.12.2015.
 */
public interface AllAccessService {
    public void copyFormToUser(UserForm form, Account account);
}
