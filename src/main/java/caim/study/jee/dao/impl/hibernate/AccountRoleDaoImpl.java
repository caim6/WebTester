package caim.study.jee.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import caim.study.jee.dao.AccountRoleDao;
import caim.study.jee.entities.AccountRole;

/**
 * @author nedis
 * @version 1.0
 */
@Repository("hiberanteAccountRoleDao")
public class AccountRoleDaoImpl extends AbstractEntityDao<AccountRole> implements AccountRoleDao {

	@Override
	protected Class<AccountRole> getEntityClass() {
		return AccountRole.class;
	}

}
