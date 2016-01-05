package caim.study.jee.dao.impl.hibernate;

import caim.study.jee.dao.AccountRegistrationDao;
import caim.study.jee.entities.AccountRegistration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by caim6 on 11.11.2015.
 */
@Repository("hibernateAccountRedistrationDao")
@SuppressWarnings("unchecked")
public class AccountRegistrationDaoImpl extends AbstractEntityDao<AccountRegistration> implements AccountRegistrationDao {
    @Override
    protected Class<AccountRegistration> getEntityClass() {
        return AccountRegistration.class;
    }

    @Override
    public AccountRegistration findByHash(final String hash) {
        return (AccountRegistration) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("hash", hash)).uniqueResult();
    }
}
