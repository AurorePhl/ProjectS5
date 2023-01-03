package com.project.quizestce.util;

import com.project.quizestce.exception.ResourceNotFoundException;

public final class CtrlPreconditions {

	public static <T> T checkFound(T object) {
		if(object == null)
			throw new ResourceNotFoundException("Aucun model n'est répertorié avec cet id.");
		return object;
	}
	
	
}
