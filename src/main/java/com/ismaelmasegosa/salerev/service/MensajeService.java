package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.MensajeModel;

public interface MensajeService {

	public List<MensajeModel> findAll();

	public List<MensajeModel> findByLeido(boolean leido);

	public List<MensajeModel> findByReceptor(String id);

	public ResponseEntity<MensajeModel> sendMensaje(MensajeModel m);

	public ResponseEntity<String> removeMensaje(String id);

}
