package com.project.quizestce.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.quizestce.models.Res;

public interface ResService {
	
	public List<Res> findAll();
	
	public Res findById(String idRes);

	public Set<Res> findAllOfQuestions(String idQuestion) ;

	public String create(String idQuestion, String idBut, Res res);

	public void update(String idRes, Res res);

	public void partialUpdate(String idRes, Map<String, Object> updates);

	public void deleteById(String idQuestion, String idRes);

	
}
