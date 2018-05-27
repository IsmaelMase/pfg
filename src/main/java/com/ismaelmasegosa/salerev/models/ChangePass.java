package com.ismaelmasegosa.salerev.models;

public class ChangePass {

	String email;
	String pass;
	String passEncr;

	public ChangePass(String email, String pass, String passEncr) {
		this.email = email;
		this.pass = pass;
		this.passEncr = passEncr;
	}

	public ChangePass() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassEncr() {
		return passEncr;
	}

	public void setPassEncr(String passEncr) {
		this.passEncr = passEncr;
	}

}
