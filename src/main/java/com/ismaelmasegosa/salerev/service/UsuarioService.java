package com.ismaelmasegosa.salerev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();

	public ResponseEntity<?> addUsuario(Usuario u);
	
	public ResponseEntity<?> removeUsuario(String id);
	
}
