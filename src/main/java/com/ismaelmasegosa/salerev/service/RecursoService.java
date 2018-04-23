package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Recurso;

public interface RecursoService {
	
	public List<Recurso> findAllRecursos();
	
	public List<Recurso> findAllAulas();
	
	public List<Recurso> findAll();
	
	public ResponseEntity<?> addRecurso(Recurso u);

	public ResponseEntity<?> removeRecurso(String id);
}
