package caim.study.jee.services;

import caim.study.jee.entities.Account;


public interface SignUpService {
    Account getAccountByHash(String hash);

    void confirmAccount(Account account);

    Account getAccountByEmail(String email);
}
