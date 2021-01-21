package org.poly.services;

import java.util.List;

import org.poly.entities.Specialite;
import org.poly.repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialiteService {

	@Autowired
	SpecialiteRepository specialiteRepo;
	
	public List<Specialite> getAll(){
		return specialiteRepo.findAll();
	}
}
