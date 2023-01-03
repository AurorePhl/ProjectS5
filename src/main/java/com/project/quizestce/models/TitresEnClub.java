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
	private String idTEC;
	/* Clé primaire de la table TitresEnClub */
	private String idClubs;
	/* Clé étrangère de la table Clubs */
	private String date; 
	private String titreClub;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((idClubs == null) ? 0 : idClubs.hashCode());
		result = prime * result + ((titreClub == null) ? 0 : titreClub.hashCode());
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
		TitresEnClub other = (TitresEnClub) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idClubs == null) {
			if (other.idClubs != null)
				return false;
		} else if (!idClubs.equals(other.idClubs))
			return false;
		if (titreClub == null) {
			if (other.titreClub != null)
				return false;
		} else if (!titreClub.equals(other.titreClub))
			return false;
		return true;
	}
	public String getIdTEC() {
		return idTEC;
	}
	public void setIdTEC(String idTEC) {
		this.idTEC = idTEC;
	}

	public String getIdClubs() {
		return idClubs;
	}
	public void setIdClubs(String idClubs) {
		this.idClubs = idClubs;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitreClub() {
		return titreClub;
	}
	public void setTitreClub(String titreClub) {
		this.titreClub = titreClub;
	}
	
}
