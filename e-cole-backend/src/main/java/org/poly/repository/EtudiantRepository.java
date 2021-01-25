package org.poly.repository;

import java.util.List;

import org.poly.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	@Query("SELECT COUNT(*) FROM Etudiant")
	public int nbreEtudiant();
	
	@Query("SELECT e FROM Etudiant e WHERE e.groupe.Id = :id")
	public List<Etudiant> getClassmates(Long id);
}
