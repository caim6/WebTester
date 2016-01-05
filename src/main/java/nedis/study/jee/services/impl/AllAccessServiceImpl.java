package nedis.study.jee.services.impl;

import nedis.study.jee.entities.Account;
import nedis.study.jee.forms.UserForm;
import nedis.study.jee.services.AllAccessService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by caim6 on 06.12.2015.
 */
@Service("AllAccessService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AllAccessServiceImpl implements AllAccessService {
    @Override
    public void copyFormToUser(UserForm form, Account account) {
        account.setEmail(form.getEmail());
        account.setLogin(form.getLogin());
        account.setName(form.getName());
        account.setPassword(form.getPassword());
    }

}
