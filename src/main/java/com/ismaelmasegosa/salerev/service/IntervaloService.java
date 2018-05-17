package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.HorarioModel;

public interface IntervaloService {

	public List<HorarioModel> findAll();

	public ResponseEntity<HorarioModel> addIntervalo(HorarioModel in);

	public ResponseEntity<String> removeIntervalo(String id);

}
