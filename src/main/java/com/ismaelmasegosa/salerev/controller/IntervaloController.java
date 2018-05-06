package com.ismaelmasegosa.salerev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.entities.Intervalo;
import com.ismaelmasegosa.salerev.models.CursoModel;
import com.ismaelmasegosa.salerev.service.serviceImpl.CursoServiceImpl;
import com.ismaelmasegosa.salerev.service.serviceImpl.IntervaloServiceImpl;

@RestController
@RequestMapping("/api/intervalo")
@CrossOrigin("*")
public class IntervaloController {

	@Autowired
	@Qualifier("intervaloService")
	private IntervaloServiceImpl intervaloService;

	@GetMapping(value = "/intervalos")
	public List<String> getAllIntervalos() {
		return intervaloService.findAll();
	}

	@PostMapping(value = "/saveIntervalo")
	public ResponseEntity<String> saveCurso(@Valid @RequestBody Intervalo intervalo) {
		return intervaloService.addIntervalo(intervalo);
	}
}
