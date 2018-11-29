package org.mql.platform.dao;

import java.util.Optional;

import org.mql.platform.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chermehdi
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
