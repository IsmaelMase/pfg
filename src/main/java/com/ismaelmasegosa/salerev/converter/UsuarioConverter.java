package com.ismaelmasegosa.salerev.converter;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {

	public UsuarioModel converterEntityToModel(Usuario u) {
		UsuarioModel um = new UsuarioModel();
		if (!u.id.isEmpty()) {
			um.setId(u.getId());
		}
		um.setNombre(u.getNombre());
		um.setApellido(u.getApellido());
		um.setDni(u.getDni());
		um.setEmail(u.email);
		um.setTelefono(u.getTelefono());
		um.setPassword(u.getPassword());
		um.setCursos(u.getCursos());

		return um;
	}

	public Usuario converterModelToEntity(UsuarioModel um) {
		Usuario u = new Usuario();
		if (!um.id.isEmpty()) {
			u.setId(um.getId());
		}
		u.setNombre(um.getNombre());
		u.setApellido(um.getApellido());
		u.setDni(um.getDni());
		u.setEmail(um.email);
		u.setTelefono(um.getTelefono());
		u.setPassword(um.getPassword());
		u.setCursos(um.getCursos());

		return u;
	}
}
