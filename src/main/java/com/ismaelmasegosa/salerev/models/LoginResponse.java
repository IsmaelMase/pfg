package com.ismaelmasegosa.salerev.models;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public class LoginResponse {

	UsuarioModel usuario;

	String authorization;

	/**
	 * Constructor parametrizado
	 * 
	 * @param usuario
	 *            UsuarioModel usuario
	 * @param authorization
	 *            String authorizacion
	 */
	public LoginResponse(UsuarioModel usuario, String authorization) {
		this.usuario = usuario;
		this.authorization = authorization;
	}

	/**
	 * Contructor por defecto
	 */
	public LoginResponse() {
	}

	/**
	 * Devuelve usuario
	 * 
	 * @return UsuarioModel
	 */
	public UsuarioModel getUsuario() {
		return usuario;
	}

	/**
	 * Introducir usuari
	 * 
	 * @param usuario
	 */
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve autorizacion
	 * 
	 * @return String autorizacion
	 */
	public String getAuthorization() {
		return authorization;
	}

	/**
	 * Introducir autorizacion
	 * 
	 * @param authorization
	 *            String autorizacion
	 */
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

}
