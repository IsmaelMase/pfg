package com.ismaelmasegosa.salerev.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.models.LoginResponse;
import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.service.LoginService;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@RestController
@RequestMapping("/api/login")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * Peticion de logueo
	 * 
	 * @param usuarioModel
	 *            UsuarioModel usuario
	 * @param response
	 *            HttpServletResponse response
	 * @return ResponseEntity<LoginResponse> response entity
	 */
	@PostMapping
	public ResponseEntity<LoginResponse> login(@RequestBody UsuarioModel usuarioModel, HttpServletResponse response) {
		return loginService.login(usuarioModel, response);
	}
}
