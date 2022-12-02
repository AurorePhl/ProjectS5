package com.project.quizestce.models;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "ButeursFrancais")
@Entity
public class ButeursFrancais{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	/* Clé primaire de la table ButeursFrancais */
	private String nom;
	private String prenom;
	private int nbButsMarques;
	private int debutActivite; 
	private int finActivite;
	private Date dateDeNaissance; 
	
	public int getDebutActivite() {
		return debutActivite;
	}
	public void setDebutActivite(int debutActivite) {
		this.debutActivite = debutActivite;
	}
	public int getFinActivite() {
		return finActivite;
	}
	public void setFinActivite(int finActivite) {
		this.finActivite = finActivite;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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

	public int getNbButsMarques() {
		return nbButsMarques;
	}
	public void setNbButsMarques(int nbButsMarques) {
		this.nbButsMarques = nbButsMarques;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
}
