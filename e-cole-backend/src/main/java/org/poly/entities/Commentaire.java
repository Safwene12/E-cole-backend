package org.poly.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Commentaire implements Serializable {

	@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String commentaire;
	private Date date;
	@ManyToOne @JsonIgnore
	private Posts post;
	@ManyToOne
	private User userCom ;
}
