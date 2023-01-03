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

import com.project.quizestce.models.TitresEnSelection;
import com.project.quizestce.services.ButFrService;
import com.project.quizestce.services.TitresEnSelectionService;
import com.project.quizestce.util.CtrlPreconditions;

@RestController
public class TitresEnSelectionController {
	
	@Autowired
	private TitresEnSelectionService titresSelectServ;
	
	@Autowired
	private ButFrService butFrService;
	
	@GetMapping("/tes")
	public List<TitresEnSelection> findAll(){
		return titresSelectServ.findAll();
	}
	
	@GetMapping("/tes/{idTES}")
	public TitresEnSelection findById(@PathVariable("idTES") String identifiant) {
		TitresEnSelection res = titresSelectServ.findById(identifiant);
		CtrlPreconditions.checkFound(res);
		return res;
	}
	
	@GetMapping("/buteursFrancais/{idButeur}/tes")
	public Set<TitresEnSelection> findAllOfButeurs(@PathVariable("idButeur") String idButeur){
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		return titresSelectServ.findAllOfButeurs(idButeur);
	}
	
	@PostMapping("/buteursFrancais/{idButeur}/tes")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@PathVariable("idButeur") String idButeur, @RequestBody TitresEnSelection tes) {
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		return titresSelectServ.create(idButeur, tes);
	}
	
	@PutMapping("/tes/{idTes}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("idTes") String idTes, @RequestBody TitresEnSelection tes) {
		CtrlPreconditions.checkFound(idTes);
		titresSelectServ.update(idTes, tes);
	}
	
	@PatchMapping("/tes/{idTes}")
	@ResponseStatus(code = HttpStatus.OK)
	public void partialUpdate(@PathVariable("idTes") String idTes, @RequestBody Map<String,Object> updates) {
		CtrlPreconditions.checkFound(idTes);
		titresSelectServ.partialUpdate(idTes, updates);
	}
	
	@DeleteMapping("/buteursFrancais/{idButeur}/tes/{idTes}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void deleteById(@PathVariable("idButeur") String idButeur, @PathVariable("idTes") String idTes) {
		CtrlPreconditions.checkFound(butFrService.findById(idButeur));
		CtrlPreconditions.checkFound(idTes);
		titresSelectServ.deleteById(idButeur,idTes);
	}
}
