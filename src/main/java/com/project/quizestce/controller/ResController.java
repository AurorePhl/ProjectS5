package com.project.quizestce.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.Res;
import com.project.quizestce.services.ButFrService;
import com.project.quizestce.services.QuestionsService;
import com.project.quizestce.services.ResService;
import com.project.quizestce.util.CtrlPreconditions;

@RestController
public class ResController {
	
	@Autowired
	private ResService resService;
	
	@Autowired
	private QuestionsService questionService;
	
	@Autowired
	private ButFrService butService;
	
	@GetMapping("/res")
	public List<Res> findAll(){
		return resService.findAll();
	}
	
	@GetMapping("/res/{idRes}")
	public Res findById(@PathVariable("idRes") String identifiant) {
		Res resultat = resService.findById(identifiant);
		CtrlPreconditions.checkFound(resultat);
		return resultat;
	}
	
	@GetMapping("/questions/{idQuestion}/res")
	public Set<Res> findAllOfQuestions(@PathVariable("idQuestion") String idQuestion){
		CtrlPreconditions.checkFound(questionService.findById(idQuestion));
		return resService.findAllOfQuestions(idQuestion);
	}
	
	@PostMapping("/questions/{idQuestion}/{idButeur}/res")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@PathVariable("idQuestion") String idQuestion,@PathVariable("idButeur") String idBut, @RequestBody Res res) {
		CtrlPreconditions.checkFound(questionService.findById(idQuestion));
		CtrlPreconditions.checkFound(butService.findById(idBut));
		return resService.create(idQuestion, idBut, res);
	}
	
	@PutMapping("/res/{idRes}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("idRes") String idRes, @RequestBody Res res) {
		CtrlPreconditions.checkFound(idRes);
		resService.update(idRes, res);
	}
	
	@PatchMapping("/res/{idRes}")
	@ResponseStatus(code = HttpStatus.OK)
	public void partialUpdate(@PathVariable("idRes") String idRes, @RequestBody Map<String,Object> updates) {
		CtrlPreconditions.checkFound(idRes);
		resService.partialUpdate(idRes, updates);
	}
	
	@DeleteMapping("/questions/{idQuestion}/res/{idRes}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void deleteById(@PathVariable("idQuestion") String idQuestion, @PathVariable("idRes") String idRes) {
		CtrlPreconditions.checkFound(questionService.findById(idQuestion));
		CtrlPreconditions.checkFound(idRes);
		resService.deleteById(idQuestion,idRes);
	}
	
}
