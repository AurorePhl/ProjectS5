package com.project.quizestce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizestce.dao.ButFrRepository;
import com.project.quizestce.dao.ClubsRepository;
import com.project.quizestce.models.ButeursFrancais;
import com.project.quizestce.models.Clubs;
import com.project.quizestce.services.ClubsService;

@Service
public class ClubsServiceImpl implements ClubsService {
	
	@Autowired
	private ClubsRepository clubsRepository;
	
	@Autowired
	private ButFrRepository buteursRepository;
	
	public List<Clubs> findAll(){
		List<Clubs> liste = new ArrayList<Clubs>();
		clubsRepository.findAll().forEach(liste::add);;
		return liste;
	}
	
	public Clubs findById(String idClubs) {
		if(clubsRepository.findById(idClubs).isPresent()) {
			return clubsRepository.findById(idClubs).get();
		}
		return null;
	}

	@Override
	public Set<Clubs> findAllOfButeurs(String idButeur) {
		return buteursRepository.findById(idButeur).get().getClubs();
	}

	@Override
	public String create(String idButeur, Clubs club) {
		ButeursFrancais buteurEntity = buteursRepository.findById(idButeur).get();
		buteurEntity.getClubs().add(club);
		buteursRepository.save(buteurEntity);
		Clubs clubEntity = buteurEntity.getClubs().stream().filter(c -> c.equals(club)).findFirst().get();
		return clubEntity.getIdClubs();
	}

	@Override
	public void update(String idClub, Clubs club) {
		club.setIdClubs(idClub);
		clubsRepository.save(club);
	}

	@Override
	public void partialUpdate(String idClub, Map<String, Object> updates) {
		Clubs clubToUpdate = clubsRepository.findById(idClub).get();
		for(String key : updates.keySet()) {
			switch(key) {
			case "pays": {
				clubToUpdate.setNomClub((String) updates.get(key));
				break;
			}
			case "nomClub": {
				clubToUpdate.setPays((String) updates.get(key));
				break;
			}
			}
		}
		clubsRepository.save(clubToUpdate);
	}

	@Override
	public void deleteById(String idButeur, String idClub) {
		ButeursFrancais buteurToUpdate = buteursRepository.findById(idButeur).get();
		Set<Clubs> clubs = buteurToUpdate.getClubs();
		Clubs clubToUpdate = clubs.stream().filter(c -> c.getIdClubs().equals(idClub)).findFirst().get();
		clubs.remove(clubToUpdate);
		buteurToUpdate.setClubs(clubs);
		buteursRepository.save(buteurToUpdate);
		clubsRepository.delete(clubToUpdate);
	}
	
}
