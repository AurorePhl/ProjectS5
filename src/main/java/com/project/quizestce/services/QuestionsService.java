package com.project.quizestce.services;
import java.util.List;
import java.util.Map;

import com.project.quizestce.models.Questions;
public interface QuestionsService {
	public List<Questions> findAll();

	public Questions findById(String identifiant);

	public String create(Questions question);

	public void update(String identifiant, Questions question);

	public void partialUpdate(String identifiant, Map<String, Object> updates);

	public void deleteById(String identifiant);
	
}
