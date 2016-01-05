package nedis.study.jee.services;

import nedis.study.jee.entities.Account;

/**
 * Created by caim6 on 28.11.2015.
 */
public interface SignUpService {
    Account getAccountByHash(String hash);

    void confirmAccount(Account account);

    Account getAccountByEmail(String email);
}
