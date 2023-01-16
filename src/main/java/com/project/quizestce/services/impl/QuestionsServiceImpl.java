package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public Questions findById(String idQuestion) {
		if(questionsRepository.findById(idQuestion).isPresent()) {
			return questionsRepository.findById(idQuestion).get();
		}
		return null;
	}

	@Override
	public String create(Questions question) {
		return questionsRepository.save(question).getIdQuestion();
	}

	@Override
	public void update(String identifiant, Questions question) {
		question.setIdQuestion(identifiant);
		questionsRepository.save(question);
	}

	@Override
	public void partialUpdate(String identifiant, Map<String, Object> updates) {
		Questions questionToUpdate = questionsRepository.findById(identifiant).get();
		for(String key : updates.keySet()) {
			switch(key) {
			case "motCle": {
				questionToUpdate.setMotCle((String) updates.get(key));
				break;
			}
			case "question": {
				questionToUpdate.setQuestion((String) updates.get(key));
				break;
			}
			}
		}
		questionsRepository.save(questionToUpdate);
	}

	@Override
	public void deleteById(String identifiant) {
		questionsRepository.deleteById(identifiant);
	}

}
