package caim.study.jee.dao.impl.hibernate;

import caim.study.jee.dao.RoleDao;
import caim.study.jee.entities.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * @author nedis
 * @version 1.0
 */
@Repository("hibernateRoleDao")
public class RoleDaoImpl extends AbstractEntityDao<Role> implements RoleDao {

	@Override
	protected Class<Role> getEntityClass() {
		return Role.class;
	}

	@Override
	public Role getStudentRole() {
		return (Role) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("idRole", 4L)).uniqueResult();
	}
	@Override
	public Role getRole(Long idRole) {
		return (Role) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("idRole", idRole)).uniqueResult();
	}
}
