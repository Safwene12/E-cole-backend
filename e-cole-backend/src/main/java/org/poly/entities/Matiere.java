package org.poly.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Matiere implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	private String codeMatiere ;
	private String description ;
	private int coef ;
	private int nbreHeureCours;
	private int nbreHeureTd ;
	private int nbreHeureTp ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "matiere")
	private List<AffectationEnseigMatiere> affectationsEnseignant;
	
	@ManyToOne
	private Section section;
	@OneToMany(mappedBy = "matiere") 
    private List<Note> note; 
	@OneToMany(mappedBy = "matiere") 
    private List<AbsenceEtudiant> absenceetudiant; 
	@OneToMany(mappedBy = "matiere")
	private List<EmploisDuTemps> emploisdutemps;
}
