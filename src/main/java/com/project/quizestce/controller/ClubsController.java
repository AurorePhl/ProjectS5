package com.project.quizestce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.Clubs;
import com.project.quizestce.services.ClubsService;

@RestController
@RequestMapping("/clubs")
public class ClubsController {
	
	@Autowired
	private ClubsService clubService;
	
	@GetMapping
	public List<Clubs> findAll(){
		return clubService.findAll();
	}
	
	@GetMapping("/{idClubs}")
	public Clubs findById(@PathVariable("idClubs") int identifiant) {
		return clubService.findById(identifiant);
	}
}
