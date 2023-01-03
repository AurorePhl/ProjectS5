package com.project.quizestce.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "Réponse")
@Entity
public class Res {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String idRes;
	/* Clé primaire de la table Réponse_True */
	private boolean res;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ButeursFrancais> buteursFrancais = new HashSet<ButeursFrancais>();
	/* Clé étrangère de la table ButeursFrancais 
	 * C'est la réponse à la question. */
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRes == null) ? 0 : idRes.hashCode());
		result = prime * result + (res ? 1231 : 1237);
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
		Res other = (Res) obj;
		if (idRes == null) {
			if (other.idRes != null)
				return false;
		} else if (!idRes.equals(other.idRes))
			return false;
		if (res != other.res)
			return false;
		return true;
	}

	public String getIdRes() {
		return idRes;
	}
	
	public void setIdRes(String idRes) {
		this.idRes = idRes;
	}

	public boolean isRes() {
		return res;
	}

	public void setRes(boolean res) {
		this.res = res;
	}

	public Set<ButeursFrancais> getButeursFrancais() {
		return buteursFrancais;
	}

	public void setButeursFrancais(Set<ButeursFrancais> buteursFrancais) {
		this.buteursFrancais = buteursFrancais;
	}
	
}
