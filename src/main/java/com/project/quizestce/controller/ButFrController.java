package com.project.quizestce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.quizestce.models.ButeursFrancais;
import com.project.quizestce.services.ButFrService;

@RestController
public class ButFrController {
	
	@Autowired
	private ButFrService butFrService;
	
	@GetMapping("/buteursFrancais")
	public List<ButeursFrancais> findAll(){
		return butFrService.findAll();
	}
}
