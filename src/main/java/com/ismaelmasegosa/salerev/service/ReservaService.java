package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Reserva;

public interface ReservaService {
	
	public List<Reserva> findAll();
	
	public List<Reserva> findByUsuario(String id);
	
	public List<Reserva> findByCurso(String id);

	public ResponseEntity<?> addReserva(Reserva r);
	
	public ResponseEntity<?> removeReserva(String id);
	
}
