package caim.study.jee.dao;

import caim.study.jee.entities.Account;
import caim.study.jee.entities.Test;

import java.util.List;


public interface AccountDao extends IEntityDao<Account> {

    Account findByEmail(String email);

    public String getEmail();

    List<Test> getListTest(Account account);

    Account findByLogin(String login);

}
