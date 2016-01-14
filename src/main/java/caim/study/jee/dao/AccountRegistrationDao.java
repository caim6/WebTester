package caim.study.jee.dao;

import caim.study.jee.entities.AccountRegistration;


public interface AccountRegistrationDao extends IEntityDao<AccountRegistration> {

    AccountRegistration findByHash(final String hash);
}
