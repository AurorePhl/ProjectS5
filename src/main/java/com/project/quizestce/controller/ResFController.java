package com.project.quizestce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.ResFalse;
import com.project.quizestce.services.ResFService;

@RestController
@RequestMapping("/resF")
public class ResFController {
	
	@Autowired
	private ResFService resFService;
	
	@GetMapping
	public List<ResFalse> findAll(){
		return resFService.findAll();
	}
	
	@GetMapping("/{idRes}")
	public ResFalse findById(@PathVariable("idRes") int identifiant) {
		return resFService.findById(identifiant);
	}
}
