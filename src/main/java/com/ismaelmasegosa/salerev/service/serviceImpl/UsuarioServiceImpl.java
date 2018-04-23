package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Override
	public ResponseEntity<?> addUsuario(Usuario u) {
		try {
			Usuario uSave = usuarioRepository.save(u);

			if (uSave == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<?> removeUsuario(String id) {
		try {

			usuarioRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Usuario> findAll() {

		return usuarioRepository.findAll();
	}

}
