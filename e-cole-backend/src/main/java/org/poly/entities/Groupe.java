package org.poly.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity @Data @AllArgsConstructor @NoArgsConstructor  
public class Groupe implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	private String nomGroupe ;
	
	private String anneeScollaire ;
	@OneToMany(mappedBy = "groupe") @JsonIgnore
	private List<Etudiant> etudiants ;
	
	@OneToMany(mappedBy = "groupe") @JsonIgnore
	private List<AffectationEnseigMatiere> affectationsEnseignants;
	
	@ManyToOne
	private Section section ;
	
	@OneToMany(mappedBy = "groupe") @JsonIgnore
	private List<EmploisDuTemps> emploisdutemps;
	
	
	}



