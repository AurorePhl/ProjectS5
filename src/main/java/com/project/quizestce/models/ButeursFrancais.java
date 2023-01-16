package com.project.quizestce.models;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "ButeursFrancais")
@Entity
public class ButeursFrancais{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	/* Clé primaire de la table ButeursFrancais */
	private String nom;
	private String prenom;
	private int nbButsMarques;
	private int debutActivite; 
	private int finActivite;
	private Date dateDeNaissance; 
	private int nbTES;
	private int rang;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Clubs> clubs = new HashSet<Clubs>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<TitresEnClub> tec = new HashSet<TitresEnClub>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<TitresEnSelection> tes = new HashSet<TitresEnSelection>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Res> reponses = new HashSet<Res>();
	
	public int getDebutActivite() {
		return debutActivite;
	}
	public void setDebutActivite(int debutActivite) {
		this.debutActivite = debutActivite;
	}
	public int getFinActivite() {
		return finActivite;
	}
	public void setFinActivite(int finActivite) {
		this.finActivite = finActivite;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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

	public int getNbButsMarques() {
		return nbButsMarques;
	}
	public void setNbButsMarques(int nbButsMarques) {
		this.nbButsMarques = nbButsMarques;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public int getNbTES() {
		return nbTES;
	}
	public void setNbTES(int nbTES) {
		this.nbTES = nbTES;
	}
	
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	public Set<Clubs> getClubs() {
		return clubs;
	}
	public void setClubs(Set<Clubs> clubs) {
		this.clubs = clubs;
	}
	public Set<TitresEnClub> getTec() {
		return tec;
	}
	public void setTec(Set<TitresEnClub> tec) {
		this.tec = tec;
	}
	public Set<TitresEnSelection> getTes() {
		return tes;
	}
	public void setTes(Set<TitresEnSelection> tes) {
		this.tes = tes;
	}
	public Set<Res> getReponses() {
		return reponses;
	}
	public void setReponses(Set<Res> reponses) {
		this.reponses = reponses;
	}

	
	
}
