package com.ismaelmasegosa.salerev.models;

import java.util.List;

import com.ismaelmasegosa.salerev.entities.Curso;

/**
 * 
 * @author Ismael Masegosa
 *
 */
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

	/**
	 * Constructor parametrizado
	 *
	 * @param id
	 *            String id
	 * @param nombre
	 *            String nombre
	 * @param apellido
	 *            String apellido
	 * @param dni
	 *            String dni
	 * @param telefono
	 *            String telefono
	 * @param email
	 *            String email
	 * @param password
	 *            String password
	 * @param cursos
	 *            List<Curso> cursos
	 * @param rol
	 *            String rol
	 * @param imagen
	 *            String imagen
	 * @param estado
	 *            boolean estado
	 */
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

	/**
	 * Constructor por defecto
	 */
	public UsuarioModel() {
	}

	/**
	 * Devuelve id.
	 *
	 * @return String id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Introducir id.
	 *
	 * @param id
	 *            String id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve nombre.
	 *
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Introducir nombre.
	 *
	 * @param nombre
	 *            String nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve apellido.
	 *
	 * @return String apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Introducir apellido.
	 *
	 * @param apellido
	 *            String apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve dni.
	 *
	 * @return String dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Introducir dni.
	 *
	 * @param dni
	 *            String dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve telefono.
	 *
	 * @return String telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Introducir telefono.
	 *
	 * @param telefono
	 *            String telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve email.
	 *
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Introducir email.
	 *
	 * @param email
	 *            String email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve password.
	 *
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Introducir password.
	 *
	 * @param password
	 *            String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Devuelve cursos.
	 *
	 * @return List<Curso> cursos
	 */
	public List<Curso> getCursos() {
		return cursos;
	}

	/**
	 * Introducir cursos.
	 *
	 * @param cursos
	 *            List<Curso> cursos
	 */
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	/**
	 * Devuelve rol.
	 *
	 * @return String rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Introducir rol.
	 *
	 * @param rol
	 *            String rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Devuelve imagen.
	 *
	 * @return String imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Introducir imagen.
	 *
	 * @param imagen
	 *            String imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Devuelve estado.
	 *
	 * @return boolean estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * Introducir estado.
	 *
	 * @param estado
	 *            boolean estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
