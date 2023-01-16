package com.project.quizestce.controller;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.Questions;
import com.project.quizestce.services.QuestionsService;
import com.project.quizestce.util.CtrlPreconditions;

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
	public Questions findById(@PathVariable("idQuestion") String identifiant) {
		Questions res = questionsService.findById(identifiant);
		CtrlPreconditions.checkFound(res);
		return res;
	}
	
	@GetMapping("/mc")
	public Collection<? extends String> findMotCle(){
		List<Questions> questions = questionsService.findAll();
		CtrlPreconditions.checkFound(questions);
		Collection<String> res = new LinkedList<String>();
		for(int i=0;i<questions.size();i++) {
			res.add(questions.get(i).getMotCle());
		}
		return res;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@RequestBody Questions question) {
		return questionsService.create(question);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("id") String identifiant, @RequestBody Questions question) {
		CtrlPreconditions.checkFound(questionsService.findById(identifiant));
		questionsService.update(identifiant,question);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void partialUpdate(@PathVariable("id") String identifiant, @RequestBody Map<String,Object> updates) {
		CtrlPreconditions.checkFound(questionsService.findById(identifiant));
		questionsService.partialUpdate(identifiant,updates);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void deleteById(@PathVariable("id") String identifiant) {
		CtrlPreconditions.checkFound(questionsService.findById(identifiant));
		questionsService.deleteById(identifiant);
	}
	

}
