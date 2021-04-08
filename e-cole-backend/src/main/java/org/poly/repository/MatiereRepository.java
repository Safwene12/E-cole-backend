package org.poly.repository;

import java.util.List;

import org.poly.entities.Matiere;
import org.poly.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	
	@Query("SELECT m FROM Matiere m WHERE m.section.Id = :idSec")
	List<Matiere> findBySectionA(Long idSec);

}
