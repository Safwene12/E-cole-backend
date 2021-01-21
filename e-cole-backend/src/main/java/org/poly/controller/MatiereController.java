package org.poly.controller;

import java.util.List;

import org.poly.entities.Matiere;
import org.poly.services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin("*")
public class MatiereController {
	
	@Autowired
	MatiereService service;
	
	@GetMapping("/matiere/section/{id}")
	public List<Matiere> findMatiereByIdSection(@PathVariable("id") Long id)
	{
		return service.findMatiereByIdSection(id);
	}

}
