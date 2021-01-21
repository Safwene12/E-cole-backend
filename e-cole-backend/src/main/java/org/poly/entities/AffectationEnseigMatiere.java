package org.poly.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class AffectationEnseigMatiere implements Serializable {

	@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	@Column(length = 500) @Nullable
	private String commentaire;
	@ManyToOne
	private Enseignant enseignant ;
	@ManyToOne
	private Groupe groupe ;
	@ManyToOne
	private Matiere matiere ;
	
	
	
	
}
