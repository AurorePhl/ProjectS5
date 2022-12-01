package com.project.quizestce.services;

import java.util.List;

import com.project.quizestce.models.ResFalse;

public interface ResFService {

	public List<ResFalse> findAll();

	public ResFalse findById(int idRes);

}
