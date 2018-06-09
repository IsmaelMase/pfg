package com.ismaelmasegosa.salerev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.service.serviceImpl.UsuarioServiceImpl;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServiceImpl usuarioService;

	/**
	 * Obtener todos los usuarios
	 * 
	 * @return List<UsuarioModel> usuarios
	 */
	@GetMapping(value = "/allUsuarios")
	public List<UsuarioModel> getAllusuarios() {
		return usuarioService.findAll();
	}

	/**
	 * Obtener todos los usuarios
	 * 
	 * @return List<UsuarioModel> usuarios activos
	 */
	@GetMapping(value = "/usuarios")
	public List<UsuarioModel> getUsuariosActivos() {
		return usuarioService.findAllActivate();
	}

	/**
	 * Guardar usuario
	 * 
	 * @param usuario
	 *            Usuario usuario
	 * @return ResponseEntity<UsuarioModel> response
	 */
	@PostMapping(value = "/saveUsuario")
	public ResponseEntity<UsuarioModel> saveUsuario(@Valid @RequestBody UsuarioModel usuario) {
		return usuarioService.addUsuario(usuario);
	}

	/**
	 * Dar de baja usuario
	 * 
	 * @param id
	 * @return ResponseEntity<String> response
	 */
	@PutMapping(value = "/removeUsuario/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable("id") String id) {
		return usuarioService.removeUsuario(id);
	}

}
