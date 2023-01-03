package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.ButFrRepository;
import com.project.quizestce.dao.TitresEnClubRepository;
import com.project.quizestce.models.ButeursFrancais;
import com.project.quizestce.models.TitresEnClub;
import com.project.quizestce.services.TitresEnClubService;

@Service
public class TitresEnClubServiceImpl implements TitresEnClubService {
	
	@Autowired
	private TitresEnClubRepository tecRepository;
	
	@Autowired
	private ButFrRepository buteursRepository;
	
	public List<TitresEnClub> findAll(){
		List<TitresEnClub> liste = new ArrayList<TitresEnClub>();
		tecRepository.findAll().forEach(liste::add);;
		return liste;
	}

	public TitresEnClub findById(String idTEC) {
		if(tecRepository.findById(idTEC).isPresent()) {
			return tecRepository.findById(idTEC).get();
		}
		return null;
	}

	@Override
	public Set<TitresEnClub> findAllOfButeurs(String idButeur) {
		return buteursRepository.findById(idButeur).get().getTec();
	}

	@Override
	public String create(String idButeur, String idClub, TitresEnClub tec) {
		ButeursFrancais buteurEntity = buteursRepository.findById(idButeur).get();
		tec.setIdClubs(idClub);
		buteurEntity.getTec().add(tec);
		buteursRepository.save(buteurEntity);
		TitresEnClub tecEntity = buteurEntity.getTec().stream().filter(t -> t.equals(tec)).findFirst().get();
		return tecEntity.getIdTEC();
	}

	@Override
	public void update(String idTec, TitresEnClub tec) {
		tec.setIdTEC(idTec);
		tecRepository.save(tec);
	}

	@Override
	public void partialUpdate(String idTec, Map<String, Object> updates) {
		TitresEnClub tecToUpdate = tecRepository.findById(idTec).get();
		for(String key : updates.keySet()) {
			switch(key) {
			case "date": {
				tecToUpdate.setDate((String) updates.get(key));
				break;
			}
			case "titreClub": {
				tecToUpdate.setTitreClub((String) updates.get(key));
				break;
			}
			case "idClubs":{
				tecToUpdate.setIdClubs((String) updates.get(key));
				break;
			}
			}
		}
		tecRepository.save(tecToUpdate);
	}

	@Override
	public void deleteById(String idButeur, String idTec) {
		ButeursFrancais buteurToUpdate = buteursRepository.findById(idButeur).get();
		Set<TitresEnClub> tec = buteurToUpdate.getTec();
		TitresEnClub tecToUpdate = tec.stream().filter(t -> t.getIdTEC().equals(idTec)).findFirst().get();
		tec.remove(tecToUpdate);
		buteurToUpdate.setTec(tec);
		buteursRepository.save(buteurToUpdate);
		tecRepository.delete(tecToUpdate);
	}
}
