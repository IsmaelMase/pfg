package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.CursoModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public interface CursoService {

	/**
	 * Devuelve todos los cursos
	 * 
	 * @return List<> de Curso
	 */
	public List<CursoModel> findAll();

	/**
	 * Añadir nuevo curso
	 * 
	 * @param u
	 *            curso a registrar
	 * @return ResponseEntity<CursoModel> curso guardado
	 */
	public ResponseEntity<CursoModel> addCurso(CursoModel u);

	/**
	 * Eliminar curso
	 * 
	 * @param id
	 *            ID del curso
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> removeCurso(String id);
}
