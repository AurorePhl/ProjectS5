package com.project.quizestce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.quizestce.models.Questions;
import com.project.quizestce.services.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionsService;
	
	@GetMapping
	public List<Questions> findAll(){
		return questionsService.findAll();
	}
	
	@GetMapping("/{idQuestion}")
	public Questions findById(@PathVariable("idQuestion") int identifiant) {
		return questionsService.findById(identifiant);
	}
	

}
