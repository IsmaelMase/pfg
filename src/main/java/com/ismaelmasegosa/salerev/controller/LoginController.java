package com.ismaelmasegosa.salerev.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	@PostMapping(value = "/login")
	public ResponseEntity<HttpStatus> login(@RequestBody UsuarioModel usuarioModel, HttpServletResponse response) {
		loginService.login(usuarioModel, response);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
