package org.poly.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

import javax.persistence.OneToMany;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Role implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nomRole;
	@OneToMany(mappedBy = "role")
	private List<User> users;

}
