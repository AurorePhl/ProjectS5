package com.project.quizestce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.TitresEnClub;
import com.project.quizestce.services.TitresEnClubService;

@RestController
@RequestMapping("/titreClubs")
public class TitresEnClubController {
	
	@Autowired
	private TitresEnClubService titresClubsServ; 
	
	@GetMapping
	public List<TitresEnClub> findAll(){
		return titresClubsServ.findAll();
	}
	
	@GetMapping("/{idTEC}")
	public TitresEnClub findById(@PathVariable("idTEC") int identifiant) {
		return titresClubsServ.findById(identifiant);
	}
}
