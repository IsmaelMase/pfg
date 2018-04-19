package com.ismaelmasegosa.salerev.service;

import com.ismaelmasegosa.salerev.entities.Curso;

public interface CursoService {
	
	public boolean addCurso(Curso u);

	public boolean removeCurso(String id);
}
