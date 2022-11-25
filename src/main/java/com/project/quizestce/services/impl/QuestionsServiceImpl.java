package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.QuestionsRepository;
import com.project.quizestce.models.Questions;
import com.project.quizestce.services.QuestionsService;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	
	@Autowired
	private QuestionsRepository questionsRepository;
	
	@Override
	public List<Questions> findAll() {
		List<Questions> liste = new ArrayList<Questions>();
		questionsRepository.findAll().forEach(liste::add);;
		return liste;
	}

	@Override
	public Questions findById(String motCle) {
		
		return null;
	}

}
