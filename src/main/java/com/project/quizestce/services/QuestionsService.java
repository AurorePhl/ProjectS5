package com.project.quizestce.services;
import java.util.List;

import com.project.quizestce.models.Questions;
public interface QuestionsService {
	public List<Questions> findAll();

	public Questions findById(String motCle);
	
}
