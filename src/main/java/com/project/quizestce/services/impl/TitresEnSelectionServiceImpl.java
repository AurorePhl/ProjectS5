package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.ButFrRepository;
import com.project.quizestce.dao.TitresEnSelectionRepository;
import com.project.quizestce.models.ButeursFrancais;
import com.project.quizestce.models.TitresEnSelection;
import com.project.quizestce.services.TitresEnSelectionService;

@Service
public class TitresEnSelectionServiceImpl implements TitresEnSelectionService {
	
	@Autowired
	private TitresEnSelectionRepository tesRepository;
	
	@Autowired
	private ButFrRepository buteursRepository;
	
	public List<TitresEnSelection> findAll(){
		List<TitresEnSelection> liste = new ArrayList<TitresEnSelection>();
		tesRepository.findAll().forEach(liste::add);;
		return liste;
	}

	public TitresEnSelection findById(String idTES) {
		if(tesRepository.findById(idTES).isPresent()) {
			tesRepository.findById(idTES).get();
		}
		return null;
	}

	@Override
	public Set<TitresEnSelection> findAllOfButeurs(String idButeur) {
		return buteursRepository.findById(idButeur).get().getTes();
	}

	@Override
	public String create(String idButeur, TitresEnSelection tes) {
		ButeursFrancais buteurEntity = buteursRepository.findById(idButeur).get();
		buteurEntity.getTes().add(tes);
		buteursRepository.save(buteurEntity);
		TitresEnSelection tesEntity = buteurEntity.getTes().stream().filter(t -> t.equals(tes)).findFirst().get();
		return tesEntity.getIdTES();
	}

	@Override
	public void update(String idTes, TitresEnSelection tes) {
		tes.setIdTES(idTes);
		tesRepository.save(tes);
	}

	@Override
	public void partialUpdate(String idTes, Map<String, Object> updates) {
		TitresEnSelection tesToUpdate = tesRepository.findById(idTes).get();
		for(String key : updates.keySet()) {
			switch(key) {
			case "date": {
				tesToUpdate.setDate((String) updates.get(key));
				break;
			}
			case "titreSelect": {
				tesToUpdate.setTitreSelect((String) updates.get(key));
				break;
			}
			case "nomEquipe":{
				tesToUpdate.setNomEquipe((String) updates.get(key));
				break;
			}
			}
		}
		tesRepository.save(tesToUpdate);
	}

	@Override
	public void deleteById(String idButeur, String idTes) {
		ButeursFrancais buteurToUpdate = buteursRepository.findById(idButeur).get();
		Set<TitresEnSelection> tes = buteurToUpdate.getTes();
		TitresEnSelection tesToUpdate = tes.stream().filter(t -> t.getIdTES().equals(idTes)).findFirst().get();
		tes.remove(tesToUpdate);
		buteurToUpdate.setTes(tes);
		buteursRepository.save(buteurToUpdate);
		tesRepository.delete(tesToUpdate);
	}
}
