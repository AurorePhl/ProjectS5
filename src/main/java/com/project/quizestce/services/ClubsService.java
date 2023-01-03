package com.project.quizestce.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.quizestce.models.Clubs;

public interface ClubsService {
	
	public List<Clubs> findAll();
	
	public Clubs findById(String idClubs);
	
	public Set<Clubs> findAllOfButeurs(String idButeur);

	public String create(String idButeur, Clubs club);

	public void update(String idClub, Clubs club);

	public void partialUpdate(String idClub, Map<String, Object> updates);

	public void deleteById(String idButeur, String idClub);
}
