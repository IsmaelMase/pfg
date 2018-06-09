package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.HorarioModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public interface HorarioService {

	/**
	 * Devuelve todos los horarios
	 * 
	 * @return List<HorarioModel> horarios
	 */
	public List<HorarioModel> findAll();

	/**
	 * Añadir nuevo horario
	 * 
	 * @param in
	 *            HorarioModel horario
	 * @return ResponseEntity<HorarioModel> response
	 */
	public ResponseEntity<HorarioModel> addIntervalo(HorarioModel in);

	/**
	 * Eliminar horario
	 * 
	 * @param id
	 *            StringID del horario
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> removeIntervalo(String id);

}
