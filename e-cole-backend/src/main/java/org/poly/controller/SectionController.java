package org.poly.controller;

import java.util.List;

import org.poly.entities.Section;
import org.poly.repository.SectionRepository;
import org.poly.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import communication.SectionCom;

@RestController
@CrossOrigin("*")
public class SectionController {

	@Autowired
	SectionService service;
	@Autowired
	SectionRepository sectionRepo;
	@RequestMapping(value = "/sections",method = RequestMethod.POST)
    public void addEtudiant(@RequestBody SectionCom section){
        service.addSection(section);
    }
	@RequestMapping(value = "/sections",method = RequestMethod.GET)
	public List<Section> getAll(){
		return sectionRepo.findAll();
	}
}
