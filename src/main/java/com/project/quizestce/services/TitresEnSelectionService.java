package com.project.quizestce.services;

import java.util.List;

import com.project.quizestce.models.TitresEnSelection;

public interface TitresEnSelectionService {
	
	public List<TitresEnSelection> findAll();

	public TitresEnSelection findById(int idTES);
}
