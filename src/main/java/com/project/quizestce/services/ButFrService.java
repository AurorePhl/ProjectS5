package com.project.quizestce.services;
import java.util.List;
import com.project.quizestce.models.ButeursFrancais;
public interface ButFrService {
	public List<ButeursFrancais> findAll();

	public ButeursFrancais findById(int id);
	
}
