package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.RecursoModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public interface RecursoService {

	/**
	 * Devuelve todos los recursos.
	 *
	 * @return List<RecursoModel> recursos
	 */
	public List<RecursoModel> findAllRecursos();

	/**
	 * Devuelve todas las aulas
	 *
	 * @return List<RecursoModel> aulas
	 */
	public List<RecursoModel> findAllAulas();

	/**
	 * Devuelve todas las aulas y recursos.
	 *
	 * @return List<RecursoModel>
	 */
	public List<RecursoModel> findAll();

	/**
	 * Añadir aula o recurso.
	 *
	 * @param u
	 *            RecursoModel recurso
	 * @return ResponseEntity<RecursoModel> response
	 */
	public ResponseEntity<RecursoModel> addRecurso(RecursoModel u);

	/**
	 * Eliminar aula o recurso.
	 *
	 * @param id
	 *            String ID del recurso o aula
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> removeRecurso(String id);
}
