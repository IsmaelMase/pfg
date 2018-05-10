package com.ismaelmasegosa.salerev.service.serviceImpl;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.service.UsuarioService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario userEntityOptional = usuarioService.findByEmail(email);
		if (userEntityOptional != null) {
			Usuario usuario = userEntityOptional;

			return new User(usuario.getEmail(), usuario.getPassword(), emptyList());
		} else {
			throw new UsernameNotFoundException(email);
		}
	}
}
