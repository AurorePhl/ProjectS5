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

@Table(name = "Questions")
@Entity
public class Questions {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String idQuestion;
	/* Clé primaire de la table Questions */
	private String motCle;
	private String question;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Res> res = new HashSet<Res>();

	
	public String getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(String idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getMotCle() {
		return motCle;
	}
	
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<Res> getRes() {
		return res;
	}

	public void setRes(Set<Res> resT) {
		this.res = resT;
	}
	
}
