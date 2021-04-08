package org.poly.services;

import java.util.HashSet;
import java.util.Set;

import org.poly.entities.ERole;
import org.poly.entities.Enseignant;
import org.poly.entities.Role;
import org.poly.repository.EnseignantRepository;
import org.poly.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class EnseignantService {
	@Autowired
	EnseignantRepository enseignantRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	
	public void ajoutEnseignant(Enseignant enseignant) {
		 Set<Role> roles = new HashSet<>();
		String password = enseignant.getPassword();
		enseignant.setPassword(encoder.encode(password));
		Role pmRole = roleRepository.findByName(ERole.ROLE_ENSEIGNANT);
        roles.add(pmRole);
        enseignant.setRoles(roles);
		enseignantRepository.save(enseignant);		
	}
}
