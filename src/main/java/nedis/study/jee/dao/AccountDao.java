package nedis.study.jee.dao;

import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.Test;

import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
public interface AccountDao extends IEntityDao<Account> {

    Account findByEmail(String email);

    public String getEmail();

    List<Test> getListTest(Account account);

    Account findByLogin(String login);

}
