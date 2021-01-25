package org.poly.response;

import java.util.List;

public class JwtResponse {
    private Long id;
	private String token;
    private String username;
    private List<String> authorities;
    private String type = "Bearer";
    private String nom ;
    private String prenom;

    public JwtResponse(String accessToken,Long id , String username, List<String> role ) {
        this.id = id;
    	this.token = accessToken;
        this.username=username;
        this.authorities=role;
        
    }

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
        return username;
    }
    public Long getId() {
        return id;
    }
	public void setId(Long id) {
		this.id = id;
	}
    public void setUsername(String username) {
        this.username = username;
    }
  



    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}