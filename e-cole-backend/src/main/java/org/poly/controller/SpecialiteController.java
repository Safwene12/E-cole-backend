package org.poly.controller;

import java.util.List;

import org.poly.entities.Specialite;
import org.poly.repository.SpecialiteRepository;
import org.poly.services.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import communication.SectionCom;

@CrossOrigin("*")
@RestController
public class SpecialiteController {
	
	@Autowired
	SpecialiteService service;
	@Autowired
	SpecialiteRepository specRepo;
	
	@GetMapping("/specialites")
    public List<Specialite> getAll(){
		return service.getAll();
    }
	@RequestMapping(value = "/specialites",method = RequestMethod.POST)
    public void addEtudiant(@RequestBody Specialite spec){
      specRepo.save(spec);
    }
	@RequestMapping(value = "/nbreSpec",method = RequestMethod.GET)
    public int nbreEtud() {
    	return specRepo.nbreSpec();
    }

}
