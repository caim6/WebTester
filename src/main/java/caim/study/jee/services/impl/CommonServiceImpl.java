package caim.study.jee.services.impl;

import caim.study.jee.dao.AccountRegistrationDao;
import caim.study.jee.dao.AccountRoleDao;
import caim.study.jee.dao.RoleDao;
import caim.study.jee.entities.Account;
import caim.study.jee.entities.AccountRegistration;
import caim.study.jee.entities.AccountRole;
import caim.study.jee.entities.Role;
import caim.study.jee.exceptions.InvalidUserInputException;
import caim.study.jee.security.CurrentAccount;
import com.restfb.types.User;
import caim.study.jee.components.EntityBuilder;
import caim.study.jee.dao.AccountDao;
import caim.study.jee.forms.UserForm;
import caim.study.jee.security.SecurityUtils;
import caim.study.jee.services.CommonService;
import caim.study.jee.utils.ReflectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Service("commonService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommonServiceImpl implements CommonService {

    @Autowired
    private AccountDao accountDao;


    @Autowired
    private AccountRegistrationDao accountRegistrationDao;

    @Autowired
    @Qualifier("hibernateRoleDao")
    private RoleDao roleDao;

    @Autowired
    private AccountRoleDao accountRoleDao;

    @Autowired
    private EntityBuilder entityBuilder;
    @Autowired
    private TemplateServiceImpl templateService;


    public CommonServiceImpl() {
        super();
    }

    @Override
    public Account login(String login, String password, int role) throws InvalidUserInputException {
        Account a = accountDao.findByLogin(login);
        if (a == null) {
            throw new InvalidUserInputException("Bad credentials");
        }
        if (!StringUtils.equals(password, a.getPassword())) {
            throw new InvalidUserInputException("Bad credentials");
        }
        if (!a.getActive()) {
            throw new InvalidUserInputException("Account is not active");
        }
        boolean found = false;
        for (AccountRole ar : a.getAccountRoles()) {
            if (ar.getRole().getIdRole().intValue() == role) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new InvalidUserInputException("Current account does not have selected role");
        }
        return a;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = {InvalidUserInputException.class, RuntimeException.class})
    public Account login(User user) throws InvalidUserInputException, FileNotFoundException, MessagingException, UnknownHostException {
        Account a = accountDao.findByLogin(user.getEmail());
        if (a != null) {
            return a;
        } else {
            UserForm form = new UserForm();
            form.setEmail(user.getEmail());
            form.setName(user.getName());
            form.setLogin(user.getEmail());

            UUID pwd = UUID.randomUUID();//generate temp password
            form.setPassword(pwd.toString());

            return signUp(form, false);
        }
    }


    @Override
    @Transactional(readOnly = false, rollbackFor = {InvalidUserInputException.class, RuntimeException.class})
    public Account signUp(UserForm form, boolean sendVerificationEmail) throws InvalidUserInputException, MessagingException, FileNotFoundException {

        Account a = addAccount(form);
        if (sendVerificationEmail) {
            templateService.sendVerificationEmail(form);
        }

        return a;
    }

    @Override
    @Transactional
    public Account addAccount(UserForm form) {
        Account a = entityBuilder.buildAccount();
        ReflectionUtils.copyByFields(a, form);
        accountDao.save(a);

        String hash = UUID.randomUUID().toString();
        form.setHash(hash);

        addHashToAccount(a, hash);

        initStudentRole(a);

        return a;
    }


    @Override
    @Transactional
    public void updateAccount(Account account) {
        account.setUpdated(new Timestamp(System.currentTimeMillis()));
        accountDao.update(account);
    }

    private void addHashToAccount(Account a, String hash) {
        AccountRegistration aReg = new AccountRegistration();
        aReg.setAccount(a);
        aReg.setIdAccountRegistration(a.getIdAccount());
        aReg.setHash(hash);
        accountRegistrationDao.save(aReg);
    }

    private void initStudentRole(Account a) {
        Role r = roleDao.getStudentRole();
        AccountRole ar = entityBuilder.buildAccountRole(a, r);
        accountRoleDao.save(ar);
    }

    @Override
    public Account getLoginAccount() {
        CurrentAccount currentAccount = SecurityUtils.getCurrentAccount();
        return accountDao.findById(currentAccount.getIdAccount());
    }

    @Override
    public List<Role> listAllRoles() {
        return roleDao.findAll();
    }

    @Override
    @Transactional
    public void initRoles(List<String> checkRoles, Account a) {
        if (a.getAccountRoles() != null) {
            for (AccountRole ar : a.getAccountRoles()) {
                String id = String.valueOf(ar.getRole().getId());
                if (checkRoles.contains(id)) {
                    checkRoles.remove(id);
                } else {
                    accountRoleDao.delete(ar);
                }
            }
        }

        for (String str : checkRoles) {
            Role r = roleDao.getRole(Long.valueOf(str));
            AccountRole ar = entityBuilder.buildAccountRole(a, r);
            accountRoleDao.save(ar);
        }
    }
}
