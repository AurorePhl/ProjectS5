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

import com.project.quizestce.models.Clubs;
import com.project.quizestce.services.ButFrService;
import com.project.quizestce.services.ClubsService;
import com.project.quizestce.util.CtrlPreconditions;

@RestController
public class ClubsController {
	
	@Autowired
	private ClubsService clubService;
	
	@Autowired
	private ButFrService butFrService;
	
	@GetMapping("/clubs")
	public List<Clubs> findAll(){
		return clubService.findAll();
	}
	
	@GetMapping("/clubs/{idClubs}")
	public Clubs findById(@PathVariable("idClubs") String identifiant) {
		Clubs res = clubService.findById(identifiant);
		CtrlPreconditions.checkFound(res);
		return res;
	}
	
	@GetMapping("/buteursFrancais/{idButeur}/clubs")
	public Set<Clubs> findAllOfButeurs(@PathVariable("idButeur") String idButeur){
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		return clubService.findAllOfButeurs(idButeur);
	}
	
	@PostMapping("/buteursFrancais/{idButeur}/clubs")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@PathVariable("idButeur") String idButeur, @RequestBody Clubs club) {
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		return clubService.create(idButeur, club);
	}
	
	@PutMapping("/clubs/{idClubs}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("idClubs") String idClub, @RequestBody Clubs club) {
		CtrlPreconditions.checkFound(idClub);
		clubService.update(idClub, club);
	}
	
	@PatchMapping("/clubs/{idClubs}")
	@ResponseStatus(code = HttpStatus.OK)
	public void partialUpdate(@PathVariable("idClubs") String idClub, @RequestBody Map<String,Object> updates) {
		CtrlPreconditions.checkFound(idClub);
		clubService.partialUpdate(idClub, updates);
	}
	
	@DeleteMapping("/buteursFrancais/{idButeur}/clubs/{idClubs}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void deleteById(@PathVariable("idButeur") String idButeur, @PathVariable("idClubs") String idClub) {
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		CtrlPreconditions.checkFound(idClub);
		clubService.deleteById(idButeur,idClub);
	}
}
