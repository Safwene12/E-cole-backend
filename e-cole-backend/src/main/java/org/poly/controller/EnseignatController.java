package org.poly.controller;

import java.util.List;

import org.poly.entities.Enseignant;
import org.poly.repository.EnseignantRepository;
import org.poly.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class EnseignatController {
	
	
	@Autowired
	EnseignantService enseignantService;
	@Autowired
	EnseignantRepository enseignantRepository;
	
    @RequestMapping(value = "/enseignants",method = RequestMethod.POST)
    public void addEnseignant(@RequestBody Enseignant enseignant){
        enseignantService.ajoutEnseignant(enseignant);
    }
    
    @GetMapping("/enseignants")
    public List<Enseignant> findAll()
    {
    	return enseignantRepository.findAll();
    }
    @RequestMapping(value = "/nbreEnseignants",method = RequestMethod.GET)
    public int nbreEtud() {
    	return enseignantRepository.nbreEnseignants();
    }

}
