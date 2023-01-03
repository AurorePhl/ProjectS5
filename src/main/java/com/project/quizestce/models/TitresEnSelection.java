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
	private String idTES;
	/* Clé primaire de la table TitresEnSelection */
	private String date;
	private String nomEquipe;
	private String titreSelect;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((nomEquipe == null) ? 0 : nomEquipe.hashCode());
		result = prime * result + ((titreSelect == null) ? 0 : titreSelect.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TitresEnSelection other = (TitresEnSelection) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (nomEquipe == null) {
			if (other.nomEquipe != null)
				return false;
		} else if (!nomEquipe.equals(other.nomEquipe))
			return false;
		if (titreSelect == null) {
			if (other.titreSelect != null)
				return false;
		} else if (!titreSelect.equals(other.titreSelect))
			return false;
		return true;
	}
	public String getIdTES() {
		return idTES;
	}
	public void setIdTES(String idTES) {
		this.idTES = idTES;
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
