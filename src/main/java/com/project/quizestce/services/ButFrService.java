package com.project.quizestce.services;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.quizestce.models.ButeursFrancais;
public interface ButFrService {
	public List<ButeursFrancais> findAll();

	public ButeursFrancais findById(String id);

	public String create(ButeursFrancais buteurFrancais);

	public void update(String identifiant, ButeursFrancais buteurFrancais);

	public void partialUpdate(String identifiant, Map<String, Object> updates);

	public void deleteById(String identifiant);

	public Set<ButeursFrancais> findAllOfRes(String idRes);

	public String createByRes(String idRes, String idBut);

	public void deleteByIdRes(String idRes, String idButeur);

}
