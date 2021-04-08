package org.poly.entities;

import java.io.Serializable;
import java.util.List;

import javax.crypto.Mac;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;import lombok.Data;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class EmploisDuTemps implements Serializable {

	@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String jour ;
	private String heureDebut ;
	private String heureFin ;
	@ManyToOne
    private Groupe groupe ;
	@ManyToOne
    private Salle salle ;
	@ManyToOne
    private Enseignant enseignant ;
	@ManyToOne
    private Matiere matiere ;
	
	
}
