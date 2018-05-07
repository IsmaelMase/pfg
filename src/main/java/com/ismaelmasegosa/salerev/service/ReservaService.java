package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.ReservaModel;

public interface ReservaService {

	// public List<ReservaModel> findAll();
	//
	// public List<ReservaModel> findByUsuario(String id);
	//
	public List<ReservaModel> findByRecurso(String id);

	public List<String> getFechasNoDisponibles(List<String> horas, String idRecurso);

	public ResponseEntity<String> addReserva(ReservaModel r);

	public ResponseEntity<String> removeReserva(String id);

}
