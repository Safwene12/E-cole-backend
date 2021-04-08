package org.poly.repository;

import org.poly.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.lang.String;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface SectionRepository extends JpaRepository<Section, Long> {

	@Query("SELECT s.specialite.nomSpecialite FROM Section s WHERE s.nomSection = :nomsection")
	String findByNomSection(String nomsection);
	
	
}
