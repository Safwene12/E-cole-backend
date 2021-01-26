package org.poly.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="user_type")
@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "utilisateur")
public class User implements Serializable {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
private String username;
private String password;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(	name = "user_roles", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))

private Set<Role> roles = new HashSet<>();
@OneToMany(mappedBy = "userEnv")
@JsonIgnore
private List<Message> inbox ;

@OneToMany(mappedBy = "userDest")
@JsonIgnore
private List<Message> sent;
@OneToMany(mappedBy = "userCom")
@JsonIgnore
private List<Commentaire> comments;
@OneToMany(mappedBy = "userPo")
@JsonIgnore
private List<Posts> posts;
public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}

}
