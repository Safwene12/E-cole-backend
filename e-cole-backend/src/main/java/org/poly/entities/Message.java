package org.poly.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Message implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(length = 50)
	private String objet;
	@Column(length = 500)
	private String message ;
	private Boolean vu;
	private Boolean trash;
	private Date date;
//	@OneToMany(mappedBy = "message")
//	private List<UploadFileResponse> files;
	@ManyToOne
	private User userDest;
	@ManyToOne
	private User userEnv;
}
