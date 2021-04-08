package org.poly.repository;

import java.util.Optional;

import org.poly.entities.ERole;
import org.poly.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(ERole name);
	@Query("SELECT r.name FROM Role r WHERE r.Id = :idUs")
	String findNameById(Long idUs);
}
