package org.poly.controller;

import java.util.List;

import org.poly.entities.Groupe;
import org.poly.repository.GroupeRepository;
import org.poly.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import communication.PostGroupe;

@RestController
@CrossOrigin("*")
public class GroupeController {
	
	@Autowired
	private GroupeRepository groupeRepository ;
	@Autowired
	private GroupeService services;
	@RequestMapping(value = "/groupes/section/{id}",method = RequestMethod.POST)
	public void addGroupe(@RequestBody PostGroupe body , @PathVariable("id") Long id)
	{
		 services.save(body , id);
	}
	@RequestMapping(value = "/groupes/section/{idSec}",method = RequestMethod.GET)
	public List<Groupe> getGroupeBySection(@PathVariable("idSec") Long idSec)
	{
		return groupeRepository.findGroupeBySection(idSec);
	}
	@RequestMapping(value = "/nbreGroupe",method = RequestMethod.GET)
    public int nbreEtud() {
    	return groupeRepository.nbreGroupe();
    }

}
