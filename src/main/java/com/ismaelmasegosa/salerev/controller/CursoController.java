package com.ismaelmasegosa.salerev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.models.CursoModel;
import com.ismaelmasegosa.salerev.service.serviceImpl.CursoServiceImpl;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@RestController
@RequestMapping("/api/curso")
@CrossOrigin("*")
public class CursoController {

	@Autowired
	@Qualifier("cursoService")
	private CursoServiceImpl cursoService;

	/**
	 * Obtener todos los cursos
	 * 
	 * @return List<CursoModel> cursos
	 */
	@GetMapping(value = "/cursos")
	public List<CursoModel> getAllCursos() {
		return cursoService.findAll();
	}

	/**
	 * Guardar curso.
	 *
	 * @param curso
	 *            CursoModel curso
	 * @return ResponseEntity<CursoModel> response entity
	 */
	@PostMapping(value = "/saveCurso")
	public ResponseEntity<CursoModel> saveCurso(@Valid @RequestBody CursoModel curso) {
		return cursoService.addCurso(curso);
	}

	/**
	 * Borrar curso.
	 *
	 * @param id
	 *            String id
	 * @return ResponseEntity<String> entity
	 */
	@DeleteMapping(value = "/removeCurso/{id}")
	public ResponseEntity<String> deleteCurso(@PathVariable("id") String id) {
		return cursoService.removeCurso(id);
	}
}
