package nedis.study.jee.services;

import nedis.study.jee.entities.Account;
import nedis.study.jee.forms.UserForm;

/**
 * Created by caim6 on 06.12.2015.
 */
public interface AllAccessService {
    public void copyFormToUser(UserForm form, Account account);
}
