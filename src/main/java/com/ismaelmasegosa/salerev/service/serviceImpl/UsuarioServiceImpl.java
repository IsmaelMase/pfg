package com.ismaelmasegosa.salerev.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public boolean addUsuario(Usuario u) {
		try {
			Usuario uSave = usuarioRepository.save(u);

			if (uSave == null) {
				return false;
			}

			return true;
		} catch (Exception e) {

			return false;

		}

	}

	@Override
	public boolean removeUsuario(String id) {
		try {

			usuarioRepository.deleteById(id);

			return true;

		} catch (Exception e) {

			return false;

		}
	}

}
