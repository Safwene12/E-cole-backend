package org.poly.services;

import java.util.List;

import org.poly.entities.Matiere;
import org.poly.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatiereService {
	
	@Autowired
	private MatiereRepository matiereRepository;

	public List<Matiere> findMatiereByIdSection(Long id)
	{
		return matiereRepository.findBySectionA(id);
	}
}
