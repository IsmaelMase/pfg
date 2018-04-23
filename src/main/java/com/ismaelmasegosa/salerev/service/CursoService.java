package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Curso;

public interface CursoService {
	
	public List<Curso> findAll();
	
	public ResponseEntity<?> addCurso(Curso u);

	public ResponseEntity<?> removeCurso(String id);
}
