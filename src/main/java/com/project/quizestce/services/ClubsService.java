package com.project.quizestce.services;

import java.util.List;

import com.project.quizestce.models.Clubs;

public interface ClubsService {
	
	public List<Clubs> findAll();
	
	public Clubs findById(int idClubs);
}
