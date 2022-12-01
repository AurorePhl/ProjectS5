package com.project.quizestce.services;

import java.util.List;

import com.project.quizestce.models.ResTrue;

public interface ResTService {

	public List<ResTrue> findAll();
	
	public ResTrue findById(int idRes);

}
