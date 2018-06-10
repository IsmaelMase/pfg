package com.ismaelmasegosa.salerev.controller;

import java.util.List;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.models.ReservaModel;
import com.ismaelmasegosa.salerev.service.serviceImpl.ReservaServiceImpl;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@RestController
@RequestMapping("/api/reserva")
@CrossOrigin("*")
public class ReservaController {

	@Autowired
	@Qualifier("reservaService")
	private ReservaServiceImpl reservaService;

	/**
	 * Obtener reservas by usuario.
	 *
	 * @param id
	 *            String id
	 * @param skip
	 *            int skip
	 * @param fechas
	 *            String fechas
	 * @return List<ReservaModel> reservas por usuario
	 */
	@PostMapping(value = "/reservasByUsuario/{id}/{skip}")
	public List<ReservaModel> getReservasByUsuario(@PathVariable("id") String id, @PathVariable("skip") int skip,
			@Valid @RequestBody String fechas) {
		return reservaService.findByUsuario(id, skip, fechas);
	}

	/**
	 * Obtener reservas by recurso.
	 *
	 * @param id
	 *            String id
	 * @param skip
	 *            int skip
	 * @param fecha
	 *            String fecha
	 * @return List<ReservaModel> reservas por recurso
	 */
	@PostMapping(value = "/reservasByRecurso/{id}")
	public List<ReservaModel> getReservasByRecurso(@PathVariable("id") String id, @Valid @RequestBody String fecha) {
		return reservaService.findByRecurso(id, fecha);
	}

	/**
	 * Obtener reservas by usuario and fecha.
	 *
	 * @param id
	 *            String id
	 * @param fecha
	 *            String fechas
	 * @return List<ReservaModel> reservas por usuario and fecha
	 */
	@PostMapping(value = "/reservasByUsuarioAndFecha/{id}")
	public List<ReservaModel> getReservasByUsuarioAndFecha(@PathVariable("id") String id,
			@Valid @RequestBody String fecha) {
		return reservaService.findByUsuarioAndFecha(id, fecha);
	}

	/**
	 * Obtener reservas by recurso and fecha.
	 *
	 * @param id
	 *            String id
	 * @param fecha
	 *            String fechas
	 * @return List<ReservaModel> reservas por recurso and fecha
	 */
	@PostMapping(value = "/reservasByRecursoAndFecha/{id}")
	public List<ReservaModel> getReservasByRecursoAndFecha(@PathVariable("id") String id,
			@Valid @RequestBody String fecha) {
		return reservaService.findByRecursoAndfilterByFecha(id, fecha);
	}

	/**
	 * Generar tabla.
	 *
	 * @param id
	 *            String id
	 * @param horas
	 *            List<String> horas
	 * @return the tree map
	 */
	@PostMapping(value = "/generarTabla/{id}")
	public TreeMap<Integer, List<String>> generarTabla(@PathVariable("id") String id,
			@Valid @RequestBody List<String> horas) {
		return reservaService.findByRecursoAndFechasContains(id, horas);
	}

	/**
	 * Obtener fechas no disponibles.
	 *
	 * @param horas
	 *            List<String> horas
	 * @param id
	 *            String id
	 * @return List<String> fechas no disponibles
	 */
	@PostMapping(value = "/getFechasDisponibles/{id}")
	public List<String> getFechasNoDisponibles(@Valid @RequestBody List<String> horas, @PathVariable("id") String id) {
		return reservaService.getFechasNoDisponibles(horas, id);
	}

	/**
	 * Obtener horas disponibles.
	 *
	 * @param fecha
	 *            String fecha
	 * @param id
	 *            String id
	 * @return List<String> horas disponibles
	 */
	@PostMapping(value = "/getHorasNoDisponibles/{id}")
	public List<String> getHorasDisponibles(@Valid @RequestBody String fecha, @PathVariable("id") String id) {
		return reservaService.getHorasDisponibles(fecha, id);
	}

	/**
	 * Guardar reserva.
	 *
	 * @param reservaModel
	 *            ReservaModel reserva
	 * @return ResponseEntity<List<ReservaModel>> response entity
	 */
	@PostMapping(value = "/saveReserva")
	public ResponseEntity<List<ReservaModel>> saveReserva(@Valid @RequestBody ReservaModel reservaModel) {
		return reservaService.addReserva(reservaModel);
	}

	/**
	 * Borrar reserva.
	 *
	 * @param id
	 *            String id
	 * @return ResponseEntity<String> response entity
	 */
	@DeleteMapping(value = "/removeReserva/{id}")
	public ResponseEntity<String> deleteReserva(@PathVariable("id") String id) {
		return reservaService.removeReserva(id);
	}

	/**
	 * Borrar reservas de forma masiva.
	 *
	 * @param ids
	 *            String ids
	 * @return ResponseEntity<String> response entity
	 */
	@PostMapping(value = "/removeReservasMass")
	public ResponseEntity<String> deleteMassReserva(@Valid @RequestBody List<String> ids) {
		return reservaService.removeMassReserva(ids);
	}

}
