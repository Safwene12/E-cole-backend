package org.poly.services;

import javax.transaction.Transactional;

import org.poly.entities.AffectationEnseigMatiere;
import org.poly.entities.Groupe;
import org.poly.repository.AffectationEnseigMatiereRepository;
import org.poly.repository.EnseignantRepository;
import org.poly.repository.GroupeRepository;
import org.poly.repository.MatiereRepository;
import org.poly.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import communication.PostGroupe;

@Service
public class GroupeService {

	@Autowired
	private GroupeRepository groupeRepository;
	@Autowired
	private SectionRepository sectionRepo;
	@Autowired
	private AffectationEnseigMatiereRepository affectRepository;
	@Autowired
	private EnseignantRepository enseRepo;
	@Autowired
	private MatiereRepository matRepo;
	@Transactional
	public void save(PostGroupe post , Long idSec)
	{
		Groupe groupe = post.getGroupe();
		groupe.setSection(sectionRepo.getOne(idSec)); 
		groupeRepository.save(groupe);
		Groupe g = groupeRepository.findGroupeByCara(groupe.getNomGroupe(), groupe.getSection().getNomSection(), groupe.getAnneeScollaire());
		System.out.println(post.getAffects().size());
		if(post.getAffects().size()>0)
		{
			for(int i =0 ; i<post.getAffects().size() ; i++)
			{
				AffectationEnseigMatiere affectation = new AffectationEnseigMatiere();
				affectation.setMatiere(matRepo.getOne(post.getAffects().get(i).getIdMat()));
				affectation.setEnseignant(enseRepo.getOne(post.getAffects().get(i).getIdEns()));
				affectation.setGroupe(g); 
				affectRepository.save(affectation);
			}
		}
		
	}
}
