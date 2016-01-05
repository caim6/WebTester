package caim.study.jee.dao;

import caim.study.jee.entities.Role;

/**
 * @author nedis
 * @version 1.0
 */
public interface RoleDao extends IEntityDao<Role> {
    Role getStudentRole();

    Role getRole(Long idRole);
}
