package com.project.quizestce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "Réponse_False")
@Entity
public class ResFalse {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int idRes;
	/* Clé primaire de la table Réponse_False */
	private int idQuestion;
	/* Clé étrangère de la table Questions */
	private int idButeur;
	/* Clé étrangère de la table ButeursFrancais 
	 * C'est la réponse à la question. */
	
	public int getIdRes() {
		return idRes;
	}

	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public int getIdButeur() {
		return idButeur;
	}

	public void setIdButeur(int idButeur) {
		this.idButeur = idButeur;
	}
	
}
