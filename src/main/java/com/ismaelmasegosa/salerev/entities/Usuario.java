package com.ismaelmasegosa.salerev.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Document(collection = "usuarios")
public class Usuario {

	@Id
	public String id;

	public String nombre;

	public String apellido;

	@Indexed(unique = true)
	public String dni;

	public String telefono;

	@Indexed(unique = true)
	public String email;

	public String password;

	public String rol;

	public String imagen;

	public boolean estado;

	@DBRef
	public List<Curso> cursos;

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
	public Usuario(String id, String nombre, String apellido, String dni, String telefono, String email,
			String password, String rol, List<Curso> cursos, String imagen, boolean estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.cursos = cursos;
		this.imagen = imagen;
		this.estado = estado;
	}

	/**
	 * Constructor por defecto
	 */
	public Usuario() {
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
