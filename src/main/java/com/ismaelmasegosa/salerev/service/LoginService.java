package com.ismaelmasegosa.salerev.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.LoginResponse;
import com.ismaelmasegosa.salerev.models.UsuarioModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public interface LoginService {

	/**
	 * Comprueba que el usuario y contraseña enviados sean corrector
	 * 
	 * @param request
	 *            UsuarioModel datos usuario
	 * @param res
	 *            HttpServletResponse response
	 * @return ResponseEntity<LoginResponse> response
	 */
	ResponseEntity<LoginResponse> login(UsuarioModel request, HttpServletResponse res);
}
