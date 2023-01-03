package com.project.quizestce.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.quizestce.models.TitresEnSelection;

public interface TitresEnSelectionService {
	
	public List<TitresEnSelection> findAll();

	public TitresEnSelection findById(String idTES);

	public Set<TitresEnSelection> findAllOfButeurs(String idButeur);

	public String create(String idButeur, TitresEnSelection tes);

	public void update(String idTes, TitresEnSelection tes);

	public void partialUpdate(String idTes, Map<String, Object> updates);

	public void deleteById(String idButeur, String idTes);
}
