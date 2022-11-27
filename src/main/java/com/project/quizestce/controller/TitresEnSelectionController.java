package com.project.quizestce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.TitresEnSelection;
import com.project.quizestce.services.TitresEnSelectionService;

@RestController
@RequestMapping("/titresSelection")
public class TitresEnSelectionController {
	
	@Autowired
	private TitresEnSelectionService titresSelectServ;
	
	@GetMapping
	public List<TitresEnSelection> findAll(){
		return titresSelectServ.findAll();
	}
	
	@GetMapping("/{idTES}")
	public TitresEnSelection findById(@PathVariable("idTES") int identifiant) {
		return titresSelectServ.findById(identifiant);
	}
	
}
