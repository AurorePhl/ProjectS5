package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.QuestionsRepository;
import com.project.quizestce.dao.ResRepository;
import com.project.quizestce.models.Questions;
import com.project.quizestce.models.Res;
import com.project.quizestce.services.ResService;

@Service
public class ResServiceImpl implements ResService {

	@Autowired
	private ResRepository resRepository; 
	
	@Autowired 
	private QuestionsRepository questionsRepository;
	
	@Override
	public List<Res> findAll() {
		List<Res> liste = new ArrayList<Res>();
		resRepository.findAll().forEach(liste::add);;
		return liste;
	}

	@Override
	public Res findById(String idRes) {
		if(resRepository.findById(idRes).isPresent()) {
			return resRepository.findById(idRes).get();
		}
		return null;
	}

	@Override
	public Set<Res> findAllOfQuestions(String idQuestion) {
		return questionsRepository.findById(idQuestion).get().getRes();
	}

	@Override
	public String create(String idQuestion, Res res) {
		Questions questionEntity = questionsRepository.findById(idQuestion).get();
		questionEntity.getRes().add(res);
		questionsRepository.save(questionEntity);
		Res resEntity = questionEntity.getRes().stream().filter(r -> r.equals(res)).findFirst().get();
		return resEntity.getIdRes();
	}

	@Override
	public void update(String idRes, Res res) {
		res.setIdRes(idRes);
		resRepository.save(res);
	}

	@Override
	public void partialUpdate(String idRes, Map<String, Object> updates) {
		Res resToUpdate = resRepository.findById(idRes).get();
		for(String key : updates.keySet()) {
			switch(key) {
			case "res": {
				resToUpdate.setRes((boolean) updates.get(key));
				break;
			}
			}
		}
		resRepository.save(resToUpdate);
	}

	@Override
	public void deleteById(String idQuestion, String idRes) {
		Questions questionToUpdate = questionsRepository.findById(idQuestion).get();
		Set<Res> res = questionToUpdate.getRes();
		Res resToUpdate = res.stream().filter(r -> r.getIdRes().equals(idRes)).findFirst().get();
		res.remove(resToUpdate);
		questionToUpdate.setRes(res);
		questionsRepository.save(questionToUpdate);
		resRepository.delete(resToUpdate);
	}

}
