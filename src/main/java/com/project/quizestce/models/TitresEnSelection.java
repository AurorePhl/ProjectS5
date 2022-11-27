package com.project.quizestce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "TitresEnSelection")
@Entity
public class TitresEnSelection {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int idTES;
	/* Clé primaire de la table TitresEnSelection */
	private int idButeurs;
	/* Clé étrangère de la table ButeursFrancais */
	private String date;
	private String nomEquipe;
	private String titreSelect;
	
	public int getIdTES() {
		return idTES;
	}
	public void setIdTES(int idTES) {
		this.idTES = idTES;
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
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public String getTitreSelect() {
		return titreSelect;
	}
	public void setTitreSelect(String titreSelect) {
		this.titreSelect = titreSelect;
	}

}
