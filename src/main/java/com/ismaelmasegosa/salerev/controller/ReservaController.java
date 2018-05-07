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

import com.ismaelmasegosa.salerev.models.ReservaModel;
import com.ismaelmasegosa.salerev.service.serviceImpl.ReservaServiceImpl;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin("*")
public class ReservaController {

	@Autowired
	@Qualifier("reservaService")
	private ReservaServiceImpl reservaService;

	// @GetMapping(value = "/reservas")
	// public List<ReservaModel> getAllReservas() {
	// return reservaService.findAll();
	// }
	//
	// @GetMapping(value = "/reservasByUsuario/{id}")
	// public List<ReservaModel> getReservasByUsuario(@PathVariable("id") String id)
	// {
	// return reservaService.findByUsuario(id);
	// }
	//
	@GetMapping(value = "/reservasByRecurso/{id}")
	public List<ReservaModel> getReservasByRecurso(@PathVariable("id") String id) {
		return reservaService.findByRecurso(id);
	}

	@PostMapping(value = "/getFechasDisponibles/{id}")
	public List<String> getReservasByRecurso(@Valid @RequestBody List<String> horas, @PathVariable("id") String id) {
		return reservaService.getFechasNoDisponibles(horas, id);
	}

	@PostMapping(value = "/saveReserva")
	public ResponseEntity<String> saveReserva(@Valid @RequestBody ReservaModel reservaModel) {
		return reservaService.addReserva(reservaModel);
	}

	@DeleteMapping(value = "/removeReserva/{id}")
	public ResponseEntity<String> deleteReserva(@PathVariable("id") String id) {
		return reservaService.removeReserva(id);
	}
}
