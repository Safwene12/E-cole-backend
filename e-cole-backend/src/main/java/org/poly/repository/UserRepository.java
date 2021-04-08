package org.poly.repository;

import java.util.List;
import java.util.Optional;

import org.poly.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
	@Query(value = "SELECT role_id FROM user_roles u WHERE u.user_id = :idUser", 
			  nativeQuery = true)
	Long getRoleByIdUser(Long idUser);

	
}
