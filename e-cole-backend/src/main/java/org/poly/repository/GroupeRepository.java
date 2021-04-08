package org.poly.repository;

import java.util.List;

import org.poly.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface GroupeRepository extends JpaRepository<Groupe , Long> {

	@Query("SELECT g FROM Groupe g WHERE g.nomGroupe = :groupeName AND "
			+ "g.section.nomSection = :section AND g.anneeScollaire = :anneeScol ")
	public Groupe findGroupeByCara(String groupeName , String section , String anneeScol);
	
	@Query("SELECT g FROM Groupe g WHERE g.section.Id = :idSec")
	public List<Groupe> findGroupeBySection(Long idSec);
	
	@Query("SELECT COUNT(*) FROM Groupe")
	public int nbreGroupe();
}
