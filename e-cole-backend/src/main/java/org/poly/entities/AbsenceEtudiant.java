package org.poly.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class AbsenceEtudiant implements Serializable {

	@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	private String dateAbsence  ;
	private Boolean justifiée ;
	private String type ;
	@Nullable @Column(length = 500)
	private String commentaire ;
	@ManyToOne 
    private Etudiant etudiant ; 
	@ManyToOne 
    private Matiere matiere ; 
}
