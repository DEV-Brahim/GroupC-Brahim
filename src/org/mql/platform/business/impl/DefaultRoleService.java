package org.mql.platform.business.impl;

import java.util.List;

import org.mql.platform.business.RoleService;
import org.mql.platform.dao.RoleRepository;
import org.mql.platform.models.Role;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultRoleService implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	public DefaultRoleService() {
		
	}

	@Override
	public void addRole(Role role) {
		System.out.println(">>> save role");
		roleRepository.save(role);
		
	}

	@Override
	public void deleteRole(int id) {
		roleRepository.deleteById(id);
		
	}

	@Override
	public Role getRoleById(int id) {
		return roleRepository.getOne(id);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

}
