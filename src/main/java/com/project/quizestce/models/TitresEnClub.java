package com.project.quizestce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "TitresEnClub")
@Entity
public class TitresEnClub {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int idTEC;
	/* Clé primaire de la table TitresEnClub */
	private int idButeurs;
	/* Clé étrangère de la table ButeursFrancais */
	private String date; 
	private String nomClub;
	private String titreClub;
	
	public int getIdTEC() {
		return idTEC;
	}
	public void setIdTEC(int idTEC) {
		this.idTEC = idTEC;
	}
	public int getIdButeurs() {
		return idButeurs;
	}
	public void setIdButeurs(int idButeurs) {
		this.idButeurs = idButeurs;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNomClub() {
		return nomClub;
	}
	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}
	public String getTitreClub() {
		return titreClub;
	}
	public void setTitreClub(String titreClub) {
		this.titreClub = titreClub;
	}
	
}
