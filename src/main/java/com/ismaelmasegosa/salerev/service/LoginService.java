package com.ismaelmasegosa.salerev.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.ismaelmasegosa.salerev.models.LoginResponse;
import com.ismaelmasegosa.salerev.models.UsuarioModel;

public interface LoginService {

	ResponseEntity<LoginResponse> login(UsuarioModel request, HttpServletResponse res);
}
