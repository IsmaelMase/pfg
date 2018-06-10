package com.ismaelmasegosa.salerev.service;

import java.util.List;
import java.util.TreeMap;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.ReservaModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public interface ReservaService {

	/**
	 * Devuelve reservas ocupadas por usuario, paginado y fecha.
	 *
	 * @param id
	 *            String ID del usuario
	 * @param skip
	 *            int pagina de resultados
	 * @param fecha
	 *            String fecha
	 * @return List<ReservaModel> reservas
	 */
	public List<ReservaModel> findByUsuario(String id, int skip, String fecha);

	/**
	 * Devuelve reservas ocupadas y libres por recurso, paginado y fecha.
	 *
	 * @param id
	 *            String ID del recurso
	 * @param skip
	 *            int pagina de resultados
	 * @param fecha
	 *            String fecha
	 * @return List<ReservaModel> reservas
	 */
	public List<ReservaModel> findByRecurso(String id, String fecha);

	/**
	 * Devuelve reservas ocupadas por usuario y fecha.
	 *
	 * @param id
	 *            String ID del usuario
	 * @param fecha
	 *            String fecha
	 * @return List<ReservaModel> reservas
	 */
	public List<ReservaModel> findByUsuarioAndFecha(String id, String fecha);

	/**
	 * Devuelve listado de reservas ocupadas por recurso y fecha agrupados por fecha
	 * y hora.
	 *
	 * @param id
	 *            String ID del recurso
	 * @param fecha
	 *            List<String> fechas
	 * @return TreeMap<Integer, List<String>> reservas
	 */
	public TreeMap<Integer, List<String>> findByRecursoAndFechasContains(String id, List<String> fechas);

	/**
	 * Devuelve reservas ocupadas por recurso y fecha.
	 *
	 * @param id
	 *            String ID del recurso
	 * @param fecha
	 *            String fecha
	 * @return List<ReservaModel> reservas
	 */
	public List<ReservaModel> findByRecursoAndfilterByFecha(String id, String fecha);

	/**
	 * Devuelve las fechas no disponibles para un listado de horas y un recurso.
	 *
	 * @param horas
	 *            List<String> horas
	 * @param idRecurso
	 *            String ID del recurso
	 * @return List<String> fechas no disponibles
	 */
	public List<String> getFechasNoDisponibles(List<String> horas, String idRecurso);

	/**
	 * Devuelve horas disponibles para un recurso y una fecha.
	 *
	 * @param fecha
	 *            String fecha
	 * @param idRecurso
	 *            String idRecurso
	 * @return List<String> horas disponibles
	 */
	public List<String> getHorasDisponibles(String fecha, String idRecurso);

	/**
	 * Guardar reserva.
	 *
	 * @param r
	 *            ReservaModel reserva
	 * @return ResponseEntity<List<ReservaModel>> reservas guardadas
	 */
	public ResponseEntity<List<ReservaModel>> addReserva(ReservaModel r);

	/**
	 * Cancelar reservas.
	 *
	 * @param id
	 *            String id reserva
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> removeReserva(String id);

	/**
	 * Cancelar un listado de reservas.
	 *
	 * @param ids
	 *            List<String> ids de las reservas
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> removeMassReserva(List<String> ids);

}
