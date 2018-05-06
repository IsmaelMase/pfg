package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.models.RecursoModel;

public interface RecursoService {
	
	public List<RecursoModel> findAllRecursos();
	
	public List<RecursoModel> findAllAulas();
	
	public List<RecursoModel> findAll();
	
	public ResponseEntity<RecursoModel> addRecurso(RecursoModel u);

	public ResponseEntity<String> removeRecurso(String id);
}
