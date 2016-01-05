package caim.study.jee.services.impl;

import caim.study.jee.entities.AccountRegistration;
import caim.study.jee.services.SignUpService;
import caim.study.jee.dao.AccountDao;
import caim.study.jee.dao.AccountRegistrationDao;
import caim.study.jee.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caim6 on 28.11.2015.
 */
@Service("signUpService")
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    AccountRegistrationDao accountRegistrationDao;

    @Autowired
    AccountDao accountDao;

    public Account getAccountByHash(String hash) {
        AccountRegistration accountRegistration = accountRegistrationDao.findByHash(hash);
        if (accountRegistration==null){
            return null;
        }else
            return accountRegistration.getAccount();
    }

    @Override
    @Transactional
    public void confirmAccount(Account account) {
        account.setConfirmed(true);
        account.setActive(true);
        accountDao.update(account);
    }
    @Override
    public Account getAccountByEmail(String email) {
        return accountDao.findByEmail(email);
    }
}
