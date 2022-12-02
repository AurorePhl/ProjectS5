package com.project.quizestce.services.impl;

import java.util.List;
import java.util.ArrayList;

import com.project.quizestce.dao.ButFrRepository;
import com.project.quizestce.models.ButeursFrancais;
import com.project.quizestce.services.ButFrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ButFrServiceImpl implements ButFrService {
	
	@Autowired
	private ButFrRepository butFrRepository;

	@Override
	public List<ButeursFrancais> findAll() {
				List<ButeursFrancais> liste = new ArrayList<ButeursFrancais>();
				butFrRepository.findAll().forEach(liste::add);;
				return liste;
	}
	
	public ButeursFrancais findById(String id) {
		if(butFrRepository.findById(id).isPresent()) {
			return butFrRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public String create(ButeursFrancais buteurFrancais) {
		return butFrRepository.save(buteurFrancais).getId();
	}

	@Override
	public void update(String identifiant, ButeursFrancais buteurFrancais) {
		buteurFrancais.setId(identifiant);
		butFrRepository.save(buteurFrancais);
	}
	
	

}
