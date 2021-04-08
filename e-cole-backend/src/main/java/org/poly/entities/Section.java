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
@Entity  @NoArgsConstructor @Data @AllArgsConstructor
public class Section implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	private String nomSection ;
	private int niveau;
	@OneToMany(mappedBy = "section")
	@JsonIgnore
	private List<Groupe> groupes;
	@ManyToOne @JsonIgnore
	private Specialite specialite;
	@OneToMany(mappedBy = "section")
	@JsonIgnore
	private List<Matiere> matieres;
}
