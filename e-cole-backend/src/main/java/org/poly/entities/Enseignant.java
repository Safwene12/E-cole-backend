package org.poly.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@DiscriminatorValue("En")
@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Enseignant extends User implements Serializable {
	
	private String nom ;
	private String prenom ;
	private String dateDeNaissance ;
	private String lieuDeNaissance ;
	private String adresseActuelle ;
	private String AdresseOrigine ;
	private String email ;
	private String sexe ;
	private Long cin; 
	private String photo ;
	private String numTel ; 
	@OneToMany(mappedBy = "enseignant") @JsonIgnore
	private List<AffectationEnseigMatiere> affectations;
	@OneToMany(mappedBy = "enseignant")
	private List<EmploisDuTemps> emploisdutemps;
	
	





}
