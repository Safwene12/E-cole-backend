package org.poly.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Note implements Serializable {

	@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	private int noteTp ;
	private int noteTd;
	private int noteExamen ;
	@ManyToOne 
    private Etudiant etudiant ; 
	@ManyToOne 
    private Matiere matiere ; 
}
