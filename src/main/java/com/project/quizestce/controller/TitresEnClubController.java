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

import com.project.quizestce.models.TitresEnClub;
import com.project.quizestce.services.ButFrService;
import com.project.quizestce.services.ClubsService;
import com.project.quizestce.services.TitresEnClubService;
import com.project.quizestce.util.CtrlPreconditions;

@RestController
public class TitresEnClubController {
	
	@Autowired
	private TitresEnClubService titresClubsServ; 
	
	@Autowired
	private ButFrService butFrService;
	
	@Autowired
	private ClubsService clubService;
	
	@GetMapping("/tec")
	public List<TitresEnClub> findAll(){
		return titresClubsServ.findAll();
	}
	
	@GetMapping("/tec/{idTEC}")
	public TitresEnClub findById(@PathVariable("idTEC") String identifiant) {
		TitresEnClub res = titresClubsServ.findById(identifiant);
		CtrlPreconditions.checkFound(res);
		return res;
	}
	
	@GetMapping("/buteursFrancais/{idButeur}/tec")
	public Set<TitresEnClub> findAllOfButeurs(@PathVariable("idButeur") String idButeur){
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		return titresClubsServ.findAllOfButeurs(idButeur);
	}
	
	@PostMapping("/buteursFrancais/{idButeur}/clubs/{idClub}/tec")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@PathVariable("idButeur") String idButeur, @PathVariable("idClub") String idClub, @RequestBody TitresEnClub tec) {
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		CtrlPreconditions.checkFound(clubService.findById(idClub));
		return titresClubsServ.create(idButeur, idClub, tec);
	}
	
	@PutMapping("/tec/{idTec}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("idTec") String idTec, @RequestBody TitresEnClub tec) {
		CtrlPreconditions.checkFound(idTec);
		titresClubsServ.update(idTec, tec);
	}
	
	@PatchMapping("/tec/{idTec}")
	@ResponseStatus(code = HttpStatus.OK)
	public void partialUpdate(@PathVariable("idTec") String idTec, @RequestBody Map<String,Object> updates) {
		CtrlPreconditions.checkFound(idTec);
		titresClubsServ.partialUpdate(idTec, updates);
	}
	
	@DeleteMapping("/buteursFrancais/{idButeur}/tec/{idTec}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void deleteById(@PathVariable("idButeur") String idButeur, @PathVariable("idTec") String idTec) {
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		CtrlPreconditions.checkFound(idTec);
		titresClubsServ.deleteById(idButeur,idTec);
	}
}
