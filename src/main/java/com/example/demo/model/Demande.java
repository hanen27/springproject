package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "demande")
public class Demande {
	public Demande() {
		super();
	}
	public Demande(Long id_demande, String type, String date_debut, String date_fin) {
		super();
		this.id_demande = id_demande;
		this.type = type;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Long getId_demande() {
		return id_demande;
	}
	public void setId_demande(Long id_demande) {
		this.id_demande = id_demande;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id_demande;
private String type ;
private String date_debut;
private String date_fin;
@ManyToOne
@JoinColumn(name = "salariee_id", nullable = false)
private Salariee salariee;
public Salariee getSalariee() {
	return salariee;
}
public void setSalariee(Salariee salariee) {
	this.salariee = salariee;
}
}
