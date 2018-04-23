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

import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.serviceImpl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServiceImpl usuarioService;

	@GetMapping(value = "/usuarios")
	public List<Usuario> getAllusuarios() {
		return usuarioService.findAll();
	}

	@PostMapping(value = "/saveUsuario")
	public ResponseEntity<?> saveUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}

	@DeleteMapping(value = "/removeUsuario/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") String id) {
		return usuarioService.removeUsuario(id);
	}

}
