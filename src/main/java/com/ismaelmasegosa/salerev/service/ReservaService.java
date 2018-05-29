package com.ismaelmasegosa.salerev.service;

import java.util.List;
import java.util.TreeMap;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.ReservaModel;

public interface ReservaService {

	// public List<ReservaModel> findAll();
	//
	// public List<ReservaModel> findByUsuarioAndFechaContains(String id, String
	// fecha);
	public List<ReservaModel> findByUsuario(String id, int skip, int top);

	public List<ReservaModel> findByUsuarioAndFecha(String id, String fecha);

	public TreeMap<Integer, List<String>> findByRecursoAndFechasContains(String id, List<String> fechas);

	// public List<ReservaModel> findByRecursoAndFecha(String id, String mes);

	public List<ReservaModel> findByRecursoAndfilterByFecha(String id, String fecha);

	public List<String> getFechasNoDisponibles(List<String> horas, String idRecurso);

	public List<String> getHorasNoDisponibles(String fecha, String idRecurso);

	public ResponseEntity<List<ReservaModel>> addReserva(ReservaModel r);

	public ResponseEntity<String> removeReserva(String id);

}
