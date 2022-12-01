package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.ResFRepository;
import com.project.quizestce.models.ResFalse;
import com.project.quizestce.services.ResFService;

@Service
public class ResFServiceImpl implements ResFService {

	@Autowired
	private ResFRepository resRepository; 
	
	@Override
	public List<ResFalse> findAll() {
		List<ResFalse> liste = new ArrayList<ResFalse>();
		resRepository.findAll().forEach(liste::add);;
		return liste;
	}

	@Override
	public ResFalse findById(int idRes) {
		return resRepository.findById(idRes).get();
	}

}
