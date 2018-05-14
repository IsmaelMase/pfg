package com.ismaelmasegosa.salerev.models;

public class LoginResponse {

	UsuarioModel usuario;

	String authorization;

	public LoginResponse(UsuarioModel usuario, String authorization) {
		this.usuario = usuario;
		this.authorization = authorization;
	}

	public LoginResponse() {
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

}
