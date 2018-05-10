package com.ismaelmasegosa.salerev.service.serviceImpl;

import static java.util.Collections.emptyList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.service.UsuarioService;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> userEntityOptional = usuarioService.findByEmail(email);
		if (userEntityOptional.isPresent()) {
			Usuario usuario = userEntityOptional.get();
			return new User(usuario.getEmail(), usuario.getPassword(), emptyList());
		} else {
			throw new UsernameNotFoundException(email);
		}
	}
}
