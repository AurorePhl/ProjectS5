package com.project.quizestce.services.impl;

import java.util.List;
import java.util.ArrayList;
import com.project.quizestce.models.ButeursFrancais;
import org.springframework.stereotype.Service;

@Service
public class ButFrService implements com.project.quizestce.services.ButFrService {

	@Override
	public List<ButeursFrancais> findAll() {
				List<ButeursFrancais> liste = new ArrayList<ButeursFrancais>();
				ButeursFrancais j1 = new ButeursFrancais();
				j1.setId(1);
				j1.setNom("Henry");
				j1.setPrenom("Thierry");
				j1.setNbButsMarques(51);
				j1.setAge(45);
				j1.setEnActivite(false);
				liste.add(j1);
				ButeursFrancais j2 = new ButeursFrancais();
				j2.setId(2);
				j2.setNom("Giroud");
				j2.setPrenom("Olivier");
				j2.setNbButsMarques(51);
				j2.setAge(36);
				j2.setEnActivite(true);
				liste.add(j2);
				return liste;
	}

}
