package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.TitresEnSelectionRepository;
import com.project.quizestce.models.TitresEnSelection;
import com.project.quizestce.services.TitresEnSelectionService;

@Service
public class TitresEnSelectionServiceImpl implements TitresEnSelectionService {
	
	@Autowired
	private TitresEnSelectionRepository tesRepository;
	
	public List<TitresEnSelection> findAll(){
		List<TitresEnSelection> liste = new ArrayList<TitresEnSelection>();
		tesRepository.findAll().forEach(liste::add);;
		return liste;
	}

	public TitresEnSelection findById(int idTES) {
		return tesRepository.findById(idTES).get();
	}
}
