package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.TitresEnClubRepository;
import com.project.quizestce.models.TitresEnClub;
import com.project.quizestce.services.TitresEnClubService;

@Service
public class TitresEnClubServiceImpl implements TitresEnClubService {
	
	@Autowired
	private TitresEnClubRepository tecRepository;
	
	public List<TitresEnClub> findAll(){
		List<TitresEnClub> liste = new ArrayList<TitresEnClub>();
		tecRepository.findAll().forEach(liste::add);;
		return liste;
	}

	public TitresEnClub findById(int idTEC) {
		return tecRepository.findById(idTEC).get();
	}
}
