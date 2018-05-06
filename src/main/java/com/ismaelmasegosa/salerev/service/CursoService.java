package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.models.CursoModel;

public interface CursoService {
	
	public List<CursoModel> findAll();
	
	public ResponseEntity<CursoModel> addCurso(CursoModel u);

	public ResponseEntity<String> removeCurso(String id);
}
