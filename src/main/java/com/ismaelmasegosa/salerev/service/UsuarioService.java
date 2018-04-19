package com.ismaelmasegosa.salerev.service;

import com.ismaelmasegosa.salerev.entities.Usuario;

public interface UsuarioService {

	public boolean addUsuario(Usuario u);
	
	public boolean removeUsuario(String id);
	
}
