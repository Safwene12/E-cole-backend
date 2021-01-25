package org.poly.controller;

import java.util.List;

import org.poly.entities.Etudiant;
import org.poly.repository.EtudiantRepository;
import org.poly.repository.GroupeRepository;
import org.poly.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class EtudiantController {
	
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	GroupeRepository groupeRepo ;
	//@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/etudiants/groupe/{idGroupe}",method = RequestMethod.POST)
    public void addEtudiant(@RequestBody Etudiant etudiant , @PathVariable("idGroupe") Long idGroupe){
    	etudiant.setGroupe(groupeRepo.getOne(idGroupe));
        etudiantService.ajoutEtudiant(etudiant);
    }
    @RequestMapping(value = "/etudiants",method = RequestMethod.GET)
    public List<Etudiant> getAll(){
    	return etudiantRepository.findAll();
    }
    @RequestMapping(value = "/nbreEtudiants",method = RequestMethod.GET)
    public int nbreEtud() {
    	return etudiantRepository.nbreEtudiant();
    }
    @RequestMapping(value = "/etudiant/{idEtud}",method = RequestMethod.PUT)
    public void updateEtudiant(@RequestBody Etudiant etudiant , @PathVariable("idEtud") Long idEtud)
    {
    	etudiantService.updateEtudiant(etudiant, idEtud);
    }
    @RequestMapping(value = "/classmates/{id}",method = RequestMethod.GET)
    public List<Etudiant> getClassmates (@PathVariable("id") Long id)
    {
    	return etudiantRepository.getClassmates(id);
    			
    }

}
