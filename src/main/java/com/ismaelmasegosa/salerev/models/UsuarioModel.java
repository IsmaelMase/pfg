package com.ismaelmasegosa.salerev.models;

import java.util.List;

import com.ismaelmasegosa.salerev.entities.Curso;

public class UsuarioModel {

	public String id;

	public String nombre;

	public String apellido;

	public String dni;

	public String telefono;

	public String email;

	public String password;

	public List<Curso> cursos;

	public String rol;

	public String imagen;

	public boolean estado;

	public UsuarioModel(String id, String nombre, String apellido, String dni, String telefono, String email,
			String password, List<Curso> cursos, String rol, String imagen, boolean estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.cursos = cursos;
		this.rol = rol;
		this.imagen = imagen;
		this.estado = estado;

	}

	public UsuarioModel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
