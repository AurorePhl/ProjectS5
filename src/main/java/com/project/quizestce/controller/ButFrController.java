package com.project.quizestce.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.quizestce.models.ButeursFrancais;

@RestController
public class ButFrController {
	
	@GetMapping("/buteursFrancais")
	public List<ButeursFrancais> finAll(){
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
		j2.setNbButsMarques(49);
		j2.setAge(36);
		j2.setEnActivite(true);
		liste.add(j2);
		return liste;
	}
}
