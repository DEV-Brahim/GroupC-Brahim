package org.mql.platform.business.impl;

import java.util.List;

import org.mql.platform.business.RoleService;
import org.mql.platform.dao.RoleRepository;
import org.mql.platform.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultRoleService implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	public DefaultRoleService() {
		
	}

	@Override
	@Transactional
	public void addRole(Role role) {
		System.out.println(">>> save role");
		roleRepository.save(role);
		
	}

	@Override
	@Transactional
	public void deleteRole(int id) {
		roleRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public Role getRoleById(Integer id) {
		/*List<Role> roles = getAllRoles();
		for (Role role : roles) {
			if (role.getId() == id) {
				return role;
			}
		}
		return null;*/
		return roleRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

}
