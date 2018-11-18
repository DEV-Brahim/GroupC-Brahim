package org.mql.platform.business;

import java.util.List;

import org.mql.platform.models.Role;

public interface RoleService {
	
	public void addRole(Role role);
	public void deleteRole(int id);
	public Role getRoleById(int id);
	public List<Role> getAllRoles();

}
