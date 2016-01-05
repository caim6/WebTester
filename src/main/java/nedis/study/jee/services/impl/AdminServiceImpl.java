package nedis.study.jee.services.impl;

import nedis.study.jee.components.EntityBuilder;
import nedis.study.jee.dao.AccountDao;
import nedis.study.jee.dao.AccountRoleDao;
import nedis.study.jee.dao.RoleDao;
import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.AccountRole;
import nedis.study.jee.entities.Role;
import nedis.study.jee.forms.admin.AdminForm;
import nedis.study.jee.services.AdminService;
import nedis.study.jee.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
@Service("adminService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AdminServiceImpl implements AdminService {

    @Autowired
    CommonService commonService;
    @Autowired
    private AccountDao accountDao;


    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    @Qualifier("hibernateRoleDao")
    private RoleDao roleDao;

    @Autowired
    private AccountRoleDao accountRoleDao;

    @Override
    public List<Account> loadAllUser() {
        return accountDao.findAll();
    }

    @Override
    public Account getAccount(Long userId) {
        return accountDao.findById(userId);
    }

    @Override
    @Transactional
    public void updateUser(Long userId, AdminForm form) {
        Account account = accountDao.findById(userId);
        account.setName(form.getName());
        account.setPassword(form.getPassword());
        account.setLogin(form.getLogin());
        account.setActive(form.getActive());
        account.setConfirmed(form.getConfirmed());
        account.setEmail(form.getEmail());
        commonService.initRoles(form.getCheckRoles(), account);
        accountDao.update(account);
    }

    @Override
    public void copyFormToUser(AdminForm form, Account account) {
        account.setActive(form.getActive());
        account.setEmail(form.getEmail());
        account.setLogin(form.getLogin());
        account.setName(form.getName());
        account.setConfirmed(form.getConfirmed());
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        accountDao.delete(accountDao.findById(userId));
    }

    @Override
    public List<String> getRoles(Account user) {
        List<AccountRole> list = user.getAccountRoles();
        List<String> roles = new ArrayList<String>();
        for (AccountRole accountRole : list) {
            roles.add(accountRole.getRole().toString());
        }
        return roles;
    }

    @Override
    public AdminForm getAdminForm(Model model, Account user) {
        AdminForm adminForm = new AdminForm();
        List<Role> list = commonService.listAllRoles();
        adminForm.setAllRoles(list);
        adminForm.setName(user.getName());
        adminForm.setEmail(user.getEmail());
        adminForm.setLogin(user.getLogin());
        adminForm.setPassword(user.getPassword());
        adminForm.setConfirmed(user.getConfirmed());
        adminForm.setActive(user.getActive());
        adminForm.setCheckRoles(getRoles(user));
        return adminForm;
    }

}
