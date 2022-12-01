package com.project.quizestce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.ResTrue;
import com.project.quizestce.services.ResTService;

@RestController
@RequestMapping("/resT")
public class ResTController {
	
	@Autowired
	private ResTService resTService;
	
	@GetMapping
	public List<ResTrue> findAll(){
		return resTService.findAll();
	}
	
	@GetMapping("/{idRes}")
	public ResTrue findById(@PathVariable("idRes") int identifiant) {
		return resTService.findById(identifiant);
	}
	
}
