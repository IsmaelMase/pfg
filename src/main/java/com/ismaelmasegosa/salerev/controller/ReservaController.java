package com.ismaelmasegosa.salerev.controller;

import java.util.List;
import java.util.TreeMap;

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

	@GetMapping(value = "/reservasByUsuarioAndFecha/{id}/{mes}/{year}")
	public List<ReservaModel> getReservasByUsuario(@PathVariable("id") String id, @PathVariable("mes") String mes,
			@PathVariable("year") String year) {
		return reservaService.findByUsuarioAndFechaContains(id, mes + "/" + year);
	}

	@GetMapping(value = "/reservasByRecursoAndFecha/{id}/{mes}/{year}")
	public List<ReservaModel> getReservasByRecursoAndMes(@PathVariable("id") String id, @PathVariable("mes") String mes,
			@PathVariable("year") String year) {
		return reservaService.findByRecursoAndFecha(id, mes + "/" + year);
	}

	@PostMapping(value = "/reservasByRecursoAndFecha/{id}")
	public List<ReservaModel> getReservasByRecursoAndFecha(@PathVariable("id") String id,
			@Valid @RequestBody String horas) {
		return reservaService.findByRecursoAndfilterByFecha(id, horas);
	}

	@PostMapping(value = "/reservasByRecursoAndFechas/{id}")
	public TreeMap<Integer, List<String>> getReservasByRecursoAndMes(@PathVariable("id") String id,
			@Valid @RequestBody List<String> horas) {
		return reservaService.findByRecursoAndFechasContains(id, horas);
	}

	@PostMapping(value = "/getFechasDisponibles/{id}")
	public List<String> getFechasNoDisponibles(@Valid @RequestBody List<String> horas, @PathVariable("id") String id) {
		return reservaService.getFechasNoDisponibles(horas, id);
	}

	@PostMapping(value = "/getHorasNoDisponibles/{id}")
	public List<String> getHorasDisponibles(@Valid @RequestBody String fecha, @PathVariable("id") String id) {
		return reservaService.getHorasNoDisponibles(fecha, id);
	}

	@PostMapping(value = "/saveReserva")
	public ResponseEntity<List<ReservaModel>> saveReserva(@Valid @RequestBody ReservaModel reservaModel) {
		return reservaService.addReserva(reservaModel);
	}

	@DeleteMapping(value = "/removeReserva/{id}")
	public ResponseEntity<String> deleteReserva(@PathVariable("id") String id) {
		return reservaService.removeReserva(id);
	}
}
