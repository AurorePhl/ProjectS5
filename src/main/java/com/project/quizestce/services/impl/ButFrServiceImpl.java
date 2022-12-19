package com.project.quizestce.services.impl;

import java.util.List;
import java.util.Map;
import java.sql.Date;
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

	@Override
	public void partialUpdate(String identifiant, Map<String, Object> updates) {
		ButeursFrancais buteurToUpdate = butFrRepository.findById(identifiant).get();
		for(String key : updates.keySet()) {
			switch(key) {
			case "nom": {
				buteurToUpdate.setNom((String) updates.get(key));
				break;
			}
			case "prenom": {
				buteurToUpdate.setPrenom((String) updates.get(key));
				break;
			}
			case "dateDeNaissance": {
				buteurToUpdate.setDateDeNaissance((Date) updates.get(key));
				break;
			}
			case "nbButsMarques": {
				buteurToUpdate.setNbButsMarques((int) updates.get(key));
				break;
			}
			case "debutActivite": {
				buteurToUpdate.setDebutActivite((int) updates.get(key));
				break;
			}
			case "finActivite": {
				buteurToUpdate.setFinActivite((int) updates.get(key));
				break;
			}
			case "nbTES": {
				buteurToUpdate.setNbTES((int) updates.get(key));
				break;
			}
			case "nbTEC": {
				buteurToUpdate.setNbTEC((int) updates.get(key));
				break;
			}
			}
		}
		butFrRepository.save(buteurToUpdate);
	}

	@Override
	public void deleteById(String identifiant) {
		butFrRepository.deleteById(identifiant);
	}
	
	

}
