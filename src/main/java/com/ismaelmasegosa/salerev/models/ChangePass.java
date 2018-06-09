package com.ismaelmasegosa.salerev.models;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public class ChangePass {

	String email;
	String pass;
	String passEncr;

	/**
	 * Constructor parametrizado
	 * 
	 * @param email
	 *            String email
	 * @param pass
	 *            String pas
	 * @param passEncr
	 *            String passEncr
	 */
	public ChangePass(String email, String pass, String passEncr) {
		this.email = email;
		this.pass = pass;
		this.passEncr = passEncr;
	}

	/**
	 * Constructor por defecto
	 */
	public ChangePass() {
	}

	/**
	 * Devuelve email
	 * 
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Introducir email
	 * 
	 * @param email
	 *            String email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve pas
	 * 
	 * @return String pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Introducir pass
	 * 
	 * @param pass
	 *            String pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Devuelve passEncr
	 * 
	 * @return String passEncr
	 */
	public String getPassEncr() {
		return passEncr;
	}

	/**
	 * Introducir passEncr
	 * 
	 * @param pass
	 *            String passEncr
	 */
	public void setPassEncr(String passEncr) {
		this.passEncr = passEncr;
	}

}
