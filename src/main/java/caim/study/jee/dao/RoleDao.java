package caim.study.jee.dao;

import caim.study.jee.entities.Role;


public interface RoleDao extends IEntityDao<Role> {
    Role getStudentRole();

    Role getRole(Long idRole);
}
