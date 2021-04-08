package org.poly.controller;


import java.util.List;

import org.poly.entities.Enseignant;
import org.poly.repository.EnseignantRepository;
import org.poly.repository.EtudiantRepository;
import org.poly.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	EnseignantRepository enseignantRepository ;
	@GetMapping("/all")
	public String allAccess() {
		return "Welcome to your Campus.";
	}
	
	@GetMapping("/teach")
	@PreAuthorize("hasRole('ENSEIGNANT')")
	public String userAccess() {

		return "Teach Board";
	}

	@GetMapping("/stud")
	@PreAuthorize("hasRole('ETUDIANT')")
	public String moderatorAccess() {
		return "Student Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
