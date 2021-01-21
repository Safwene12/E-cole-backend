package org.poly.services;

import org.poly.entities.Section;
import org.poly.entities.Specialite;
import org.poly.repository.SectionRepository;
import org.poly.repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import communication.SectionCom;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepo;
	@Autowired
	SpecialiteRepository specRepo;
	public void addSection(SectionCom comSection) {
		Section section = new Section();
		Specialite spec = specRepo.getOne(Long.valueOf(comSection.getSpecialite()));
		section.setNomSection(comSection.getNomSection());
		section.setNiveau(comSection.getNiveau());
		section.setSpecialite(spec);
		sectionRepo.save(section);
	}
}
