package com.project.quizestce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "Clubs")
@Entity
public class Clubs {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int idClubs;
	/* Clé primaire de la table Clubs */
	private int idButeurs;
	/* Clé étrangère de la table ButeursFrancais */
	private String pays;
	private String nomClub;
	
	public int getIdClubs() {
		return idClubs;
	}
	public void setIdClubs(int idClubs) {
		this.idClubs = idClubs;
	}
	public int getIdButeurs() {
		return idButeurs;
	}
	public void setIdButeurs(int idButeurs) {
		this.idButeurs = idButeurs;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getNomClub() {
		return nomClub;
	}
	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}
	
}
