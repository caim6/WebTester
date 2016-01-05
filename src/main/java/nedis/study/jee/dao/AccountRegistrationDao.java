package nedis.study.jee.dao;

import nedis.study.jee.entities.AccountRegistration;

/**
 * Created by caim6 on 11.11.2015.
 */
public interface AccountRegistrationDao extends IEntityDao<AccountRegistration> {

    AccountRegistration findByHash(final String hash);
}