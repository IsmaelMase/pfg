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

import com.ismaelmasegosa.salerev.entities.Mensaje;
import com.ismaelmasegosa.salerev.service.serviceImpl.MensajeServiceImpl;

@RestController
@RequestMapping("/api/mensaje")
@CrossOrigin("*")
public class MensajeController {

	@Autowired
	@Qualifier("mensajeService")
	private MensajeServiceImpl mensajeService;

	@GetMapping("/mensaje")
	public List<Mensaje> findMensajes() {
		return mensajeService.findAll();
	}

	@GetMapping("/mensaje/{tipo}")
	public List<Mensaje> findMensajesByTipo(@PathVariable("tipo") String tipo) {
		return mensajeService.findByTipo(tipo);
	}

	@PostMapping(value = "/sendMensaje")
	public ResponseEntity<?> sendMensaje(@Valid @RequestBody Mensaje mensaje) {
		return mensajeService.sendMensaje(mensaje);
	}

	@DeleteMapping(value = "/removeMensaje/{id}")
	public ResponseEntity<?> deleteCurso(@PathVariable("id") String id) {
		return mensajeService.removeMensaje(id);
	}

}
