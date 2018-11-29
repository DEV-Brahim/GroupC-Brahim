package org.mql.platform.business;

import java.util.List;

import org.mql.platform.models.Role;
import org.springframework.stereotype.Service;


public interface RoleService {
	
	public void addRole(Role role);
	public void deleteRole(int id);
	public Role getRoleById(Integer id);
	public List<Role> getAllRoles();

}
