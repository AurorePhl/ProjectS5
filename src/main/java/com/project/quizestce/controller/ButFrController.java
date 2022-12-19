package com.project.quizestce.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.models.ButeursFrancais;
import com.project.quizestce.services.ButFrService;
import com.project.quizestce.util.CtrlPreconditions;

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
	public ButeursFrancais findById(@PathVariable("id") String identifiant) {
		ButeursFrancais res = butFrService.findById(identifiant);
		CtrlPreconditions.checkFound(res);
		return res;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@RequestBody ButeursFrancais buteurFrancais) {
		return butFrService.create(buteurFrancais);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("id") String identifiant, @RequestBody ButeursFrancais buteurFrancais) {
		CtrlPreconditions.checkFound(butFrService.findById(identifiant));
		butFrService.update(identifiant,buteurFrancais);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void partialUpdate(@PathVariable("id") String identifiant, @RequestBody Map<String,Object> updates) {
		CtrlPreconditions.checkFound(butFrService.findById(identifiant));
		butFrService.partialUpdate(identifiant,updates);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void deleteById(@PathVariable("id") String identifiant) {
		CtrlPreconditions.checkFound(butFrService.findById(identifiant));
		butFrService.deleteById(identifiant);
	}
	
}
