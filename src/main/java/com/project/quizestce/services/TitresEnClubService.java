package com.project.quizestce.services;

import java.util.List;

import com.project.quizestce.models.TitresEnClub;

public interface TitresEnClubService {
	
	public List<TitresEnClub> findAll();

	public TitresEnClub findById(int idTEC);
}
