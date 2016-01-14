package caim.study.jee.services.impl;

import caim.study.jee.entities.Account;
import caim.study.jee.forms.UserForm;
import caim.study.jee.services.AllAccessService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


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
