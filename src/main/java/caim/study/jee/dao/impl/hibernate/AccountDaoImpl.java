package caim.study.jee.dao.impl.hibernate;

import caim.study.jee.entities.Account;
import caim.study.jee.entities.Test;
import caim.study.jee.dao.AccountDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("hibernateAccountDao")
@SuppressWarnings("unchecked")
public class AccountDaoImpl extends AbstractEntityDao<Account> implements AccountDao {

    @Override
    public Account findByEmail(String email) {
        return (Account) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }

    @Override
    public List<Test> getListTest(Account account) {
        return (List<Test>) getSession().createCriteria(Test.class).add(Restrictions.eq("account", account)).list();
    }


    @Override
    public Account findByLogin(final String login) {
        return (Account) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("login", login)).uniqueResult();
    }


}
