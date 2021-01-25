

package org.poly.repository;
import java.util.List;

import org.poly.entities.AffectationEnseigMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface AffectationEnseigMatiereRepository extends JpaRepository<AffectationEnseigMatiere, Long> {

	@Query("SELECT a FROM AffectationEnseigMatiere a WHERE a.groupe.Id = :id ")
	public List<AffectationEnseigMatiere> getByGroupe(Long id);
}
