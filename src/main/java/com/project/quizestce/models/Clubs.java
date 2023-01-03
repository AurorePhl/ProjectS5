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
	private String idClubs;
	/* Clé primaire de la table Clubs */
	private String pays;
	private String nomClub;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomClub == null) ? 0 : nomClub.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
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
		Clubs other = (Clubs) obj;
		if (nomClub == null) {
			if (other.nomClub != null)
				return false;
		} else if (!nomClub.equals(other.nomClub))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		return true;
	}
	
	public String getIdClubs() {
		return idClubs;
	}
	public void setIdClubs(String idClubs) {
		this.idClubs = idClubs;
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
