package com.project.quizestce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizestce.exception.ResourceNotFoundException;
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
	public ButeursFrancais findById(@PathVariable("id") String identifiant) {
		ButeursFrancais res = butFrService.findById(identifiant);
		if(res == null)
			throw new ResourceNotFoundException("Aucun buteurs français n'est répertorié avec cet id.");
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
		if(butFrService.findById(identifiant) == null)
			throw new ResourceNotFoundException("Aucun buteurs français n'est répertorié avec cet id.");
		butFrService.update(identifiant,buteurFrancais);
	}
	
	
	
}
