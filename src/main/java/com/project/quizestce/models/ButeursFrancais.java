package com.project.quizestce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "ButeursFrancais")
@Entity
public class ButeursFrancais {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int id;
	/* Clé primaire de la table ButeursFrancais */
	private String nom;
	private String prenom;
	private int nbButsMarques;
	private boolean enActivite;
	private String debutActivite; 
	private String finActivite;
	private int age; 
	
	public String getDebutActivite() {
		return debutActivite;
	}
	public void setDebutActivite(String debutActivite) {
		this.debutActivite = debutActivite;
	}
	public String getFinActivite() {
		return finActivite;
	}
	public void setFinActivite(String finActivite) {
		this.finActivite = finActivite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNbButsMarques() {
		return nbButsMarques;
	}
	public void setNbButsMarques(int nbButsMarques) {
		this.nbButsMarques = nbButsMarques;
	}
	public boolean isEnActivite() {
		return enActivite;
	}
	public void setEnActivite(boolean enActivite) {
		this.enActivite = enActivite;
	}

}
