package com.ismaelmasegosa.salerev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.models.UsuarioModel;

public interface UsuarioService {

	public List<UsuarioModel> findAll();

	public Optional<Usuario> findByEmail(String email);

	public ResponseEntity<UsuarioModel> addUsuario(UsuarioModel u);

	public ResponseEntity<String> removeUsuario(String id);

}
