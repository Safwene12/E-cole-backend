package org.poly.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.poly.entities.ERole;
import org.poly.entities.Etudiant;
import org.poly.entities.Role;
import org.poly.entities.Section;
import org.poly.repository.EtudiantRepository;
import org.poly.repository.RoleRepository;
import org.poly.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import communication.EtudiantCharts;

@Service
public class EtudiantService {

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	SectionRepository sectionRepo;
	
	public void ajoutEtudiant(Etudiant etudiant) {
		 Set<Role> roles = new HashSet<>();
		String password = etudiant.getPassword();
		etudiant.setPassword(encoder.encode(password));

		Role pmRole = roleRepository.findByName(ERole.ROLE_ETUDIANT);
        roles.add(pmRole);
        etudiant.setRoles(roles);
        etudiant.setPhoto("default.jpg");
		etudiantRepository.save(etudiant);		
	}
	@Transactional
	public void updateEtudiant(Etudiant etud , Long idEtud ) {
		Etudiant etudiant = etudiantRepository.getOne(idEtud);
		
		etudiant.setAdresseActuelle(etud.getAdresseActuelle());
		etudiant.setAdresseOrigine(etud.getAdresseOrigine());
		etudiant.setNom(etud.getNom());
		etudiant.setPrenom(etud.getPrenom());
		etudiant.setEmail(etud.getEmail());
		etudiant.setNumTel(etud.getNumTel());
		etudiant.setDateDeNaissance(etud.getDateDeNaissance());
		etudiant.setLieuDeNaissance(etud.getLieuDeNaissance());
		etudiantRepository.save(etudiant);
		
	}
	public List<EtudiantCharts> getchart(){
		List<EtudiantCharts> charts = new ArrayList<>();
		List<String> s = etudiantRepository.getCharts();
		for(int i =0 ; i<s.size();i++)
		{
			EtudiantCharts e = new EtudiantCharts();
			
			e.setNbreEtud(Integer.parseInt((s.get(i)).split(",")[0]));
			e.setSection((s.get(i)).split(",")[1]);
			String sec = (s.get(i)).split(",")[1];
			String spec = sectionRepo.findByNomSection(sec);
			e.setSpec(spec);
			charts.add(e);
		}
		/**List<Section> secs = sectionRepo.findAll();
		List<EtudiantCharts> chartsCon = new ArrayList<>();
		for(int i = 0 ;i<secs.size();i++)
		{
			Boolean ok = true ; 
			for(int j = 0 ;j<charts.size();j++)
			{
				if((secs.get(i).getNomSection()).equals(charts.get(j).getSection()))
				{
					ok=false;
					break;
				}
			}
			if(ok==true)
			{
				EtudiantCharts e = new EtudiantCharts();
				e.setNbreEtud(0);
				e.setSection(secs.get(i).getNomSection());
				e.setSpec(secs.get(i).getSpecialite().getNomSpecialite());
				chartsCon.add(e);
			}
		}
		charts.addAll(chartsCon);**/
		return charts;
	}
	
}
