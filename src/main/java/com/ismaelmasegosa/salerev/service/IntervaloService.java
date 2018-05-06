package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Intervalo;

public interface IntervaloService {

	public List<String> findAll();
	
	public ResponseEntity<String> addIntervalo(Intervalo in);
	
}
