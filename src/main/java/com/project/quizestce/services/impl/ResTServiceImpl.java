package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.ResTRepository;
import com.project.quizestce.models.ResTrue;
import com.project.quizestce.services.ResTService;

@Service
public class ResTServiceImpl implements ResTService {

	@Autowired
	private ResTRepository resRepository; 
	
	@Override
	public List<ResTrue> findAll() {
		List<ResTrue> liste = new ArrayList<ResTrue>();
		resRepository.findAll().forEach(liste::add);;
		return liste;
	}

	@Override
	public ResTrue findById(int idRes) {
		return resRepository.findById(idRes).get();
	}

}
