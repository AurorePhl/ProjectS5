package com.project.quizestce.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.quizestce.models.TitresEnClub;

public interface TitresEnClubService {
	
	public List<TitresEnClub> findAll();

	public TitresEnClub findById(String idTEC);

	public Set<TitresEnClub> findAllOfButeurs(String idButeur);

	public String create(String idButeur, String idClub, TitresEnClub tec);

	public void update(String idTec, TitresEnClub tec);

	public void partialUpdate(String idTec, Map<String, Object> updates);

	public void deleteById(String idButeur, String idTec);
}
