package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salariee")
public class Salariee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)

	private Long id;
	@Column( name = "nom")
	private String  nom;
	@Column( name = "prenom")

	private String prenom;
	@Column( name = "adresse")

	private String adresse;
	@Column( name = "Tel")

	private String Tel;
	@Column( name = "email")

	private String email;
	public Salariee(Long id, String nom, String prenom, String adresse, String tel, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		Tel = tel;
		this.email = email;
	}
	public Salariee() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
