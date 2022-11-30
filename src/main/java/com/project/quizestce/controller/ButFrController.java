package com.project.quizestce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.quizestce.models.ButeursFrancais;
import com.project.quizestce.services.ButFrService;

@RestController
@RequestMapping("/buteursFrancais")
public class ButFrController {
	
	@Autowired
	private ButFrService butFrService;
	
	@GetMapping
	public List<ButeursFrancais> findAll(){
		return butFrService.findAll();
	}
	
	@GetMapping("/{id}")
	public ButeursFrancais findById(@PathVariable("id") int identifiant) {
		return butFrService.findById(identifiant);
	}
	
	
	
}
