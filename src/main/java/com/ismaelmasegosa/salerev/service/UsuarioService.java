package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.models.UsuarioModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public interface UsuarioService {

	/**
	 * Devuelve todos los usuarios.
	 *
	 * @return List<UsuarioModel> usuarios
	 */
	public List<UsuarioModel> findAll();

	/**
	 * Devuelve todos los usuarios activos.
	 *
	 * @return List<UsuarioModel> usuarios
	 */
	public List<UsuarioModel> findAllActivate();

	/**
	 * Buscar por email
	 *
	 * @param email
	 *            String email
	 * @return Usuario usuario
	 */
	public Usuario findByEmail(String email);

	/**
	 * Registrar usuario.
	 *
	 * @param u
	 *            UsuarioModel usuario
	 * 
	 * @return ResponseEntity<UsuarioModel> response
	 */
	public ResponseEntity<UsuarioModel> addUsuario(UsuarioModel u);

	/**
	 * Dar de baja a un usuario.
	 *
	 * @param id
	 *            String id usuario
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> removeUsuario(String id);

}
