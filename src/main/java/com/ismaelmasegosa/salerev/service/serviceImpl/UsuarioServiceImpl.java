package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.UsuarioConverter;
import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<UsuarioModel> addUsuario(UsuarioModel u) {
		try {
			u.setPassword(passwordEncoder.encode(u.getPassword()));
			Usuario uSave = usuarioRepository.save(usuarioConverter.converterModelToEntity(u));

			return new ResponseEntity<UsuarioModel>(usuarioConverter.converterEntityToModel(uSave), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<String> removeUsuario(String id) {
		try {

			usuarioRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<UsuarioModel> findAll() {
		ArrayList<UsuarioModel> usuarioModel = new ArrayList<>();
		for (Usuario u : usuarioRepository.findAll()) {
			usuarioModel.add(usuarioConverter.converterEntityToModel(u));
		}

		return usuarioModel;
	}

	@Override
	public Usuario findByEmail(String email) {

		return usuarioRepository.findByEmail(email);

	}

}
