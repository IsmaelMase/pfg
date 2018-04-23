package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Mensaje;

public interface MensajeService {

	public List<Mensaje> findAll();
	
	public List<Mensaje> findByTipo(String tipo);
	
	public ResponseEntity<?> sendMensaje(Mensaje m);
	
	public ResponseEntity<?> removeMensaje(String id);
	
}
