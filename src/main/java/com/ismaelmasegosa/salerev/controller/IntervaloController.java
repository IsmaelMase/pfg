package com.ismaelmasegosa.salerev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.models.HorarioModel;
import com.ismaelmasegosa.salerev.service.serviceImpl.HorarioServiceImpl;

@RestController
@RequestMapping("/api/intervalo")
@CrossOrigin("*")
public class IntervaloController {

	@Autowired
	@Qualifier("intervaloService")
	private HorarioServiceImpl intervaloService;

	@GetMapping(value = "/intervalos")
	public List<HorarioModel> getAllIntervalos() {
		return intervaloService.findAll();
	}

	@PostMapping(value = "/saveIntervalo")
	public ResponseEntity<HorarioModel> saveCurso(@Valid @RequestBody HorarioModel intervalo) {
		return intervaloService.addIntervalo(intervalo);
	}

	@DeleteMapping(value = "/removeIntervalo/{id}")
	public ResponseEntity<String> deleteIntervalo(@PathVariable("id") String id) {
		return intervaloService.removeIntervalo(id);
	}
}
