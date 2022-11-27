package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.ClubsRepository;
import com.project.quizestce.models.Clubs;
import com.project.quizestce.services.ClubsService;

@Service
public class ClubsServiceImpl implements ClubsService {
	
	@Autowired
	private ClubsRepository clubsRepository;
	
	public List<Clubs> findAll(){
		List<Clubs> liste = new ArrayList<Clubs>();
		clubsRepository.findAll().forEach(liste::add);;
		return liste;
	}
	
	public Clubs findById(int idClubs) {
		return clubsRepository.findById(idClubs).get();
	}
}
