package org.poly.controller;

import java.util.List;

import org.poly.entities.AffectationEnseigMatiere;
import org.poly.entities.Enseignant;
import org.poly.repository.AffectationEnseigMatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin("*")
public class AffectationEnseigMatiereController {

	@Autowired
	private AffectationEnseigMatiereRepository repo;
	
	 @GetMapping("/affects/{idGroupe}")
	    public List<AffectationEnseigMatiere> findAll(@PathVariable("idGroupe") Long idGroupe)
	    {
	    	return repo.getByGroupe(idGroupe);
	    }
}
