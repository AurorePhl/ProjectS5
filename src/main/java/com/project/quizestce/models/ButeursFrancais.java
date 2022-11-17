package com.project.quizestce.models;

public class ButeursFrancais {
	private int id;
	private String nom;
	private String prenom;
	private int nbButsMarques;
	private boolean enActivite;
	
	private int age; 
	
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
