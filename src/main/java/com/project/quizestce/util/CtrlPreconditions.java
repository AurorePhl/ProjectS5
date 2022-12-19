package com.project.quizestce.util;

import com.project.quizestce.exception.ResourceNotFoundException;
import com.project.quizestce.models.ButeursFrancais;

public final class CtrlPreconditions {

	public static ButeursFrancais checkFound(ButeursFrancais buteurFrancais) {
		if(buteurFrancais == null)
			throw new ResourceNotFoundException("Aucun buteurs français n'est répertorié avec cet id.");
		return buteurFrancais;
	}
}
