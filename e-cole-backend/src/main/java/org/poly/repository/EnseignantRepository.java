package org.poly.repository;

import org.poly.entities.Enseignant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	@Query("SELECT COUNT(*) FROM Enseignant")
	public int nbreEnseignants();
}
