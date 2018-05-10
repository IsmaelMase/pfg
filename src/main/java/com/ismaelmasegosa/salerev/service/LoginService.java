package com.ismaelmasegosa.salerev.service;

import javax.servlet.http.HttpServletResponse;

import com.ismaelmasegosa.salerev.models.UsuarioModel;

public interface LoginService {

	void login(UsuarioModel request, HttpServletResponse res);
}
