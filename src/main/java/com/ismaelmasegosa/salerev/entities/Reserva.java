package com.ismaelmasegosa.salerev.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Document(collection = "reservas")
public class Reserva {

	@Id
	public String id;

	@DBRef
	public Usuario usuario;

	@DBRef
	public Recurso recurso;

	@DBRef
	public Curso curso;

	public String fecha;

	public String intervalo;

	public String anotacion;

	/**
	 * Contructor parametrizado
	 * 
	 * @param id
	 *            String id
	 * @param usuario
	 *            Usuario usuario
	 * @param recurso
	 *            Recurso recurso
	 * @param curso
	 *            Curso curso
	 * @param fecha
	 *            String fecha
	 * @param intervalo
	 *            String intervalo
	 * @param anotacion
	 *            String anotacion
	 */
	public Reserva(String id, Usuario usuario, Recurso recurso, Curso curso, String fecha, String intervalo,
			String anotacion) {
		this.id = id;
		this.usuario = usuario;
		this.recurso = recurso;
		this.curso = curso;
		this.fecha = fecha;
		this.intervalo = intervalo;
		this.anotacion = anotacion;
	}

	/**
	 * Constructor por defecto
	 */
	public Reserva() {
	}

	/**
	 * Devuelve id
	 * 
	 * @return String id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Introducir id
	 * 
	 * @param id
	 *            String id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve usuario
	 * 
	 * @return Usuario usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Introducir usuario
	 * 
	 * @param usuario
	 *            Usuario usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve recurso
	 * 
	 * @return Recurso recurso
	 */
	public Recurso getRecurso() {
		return recurso;
	}

	/**
	 * Introducir recurso
	 * 
	 * @param recurso
	 *            Recurso recurso
	 */
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	/**
	 * Devuelve fecha
	 * 
	 * @return String fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Introducir fecha
	 * 
	 * @param fecha
	 *            String fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve intervalo
	 * 
	 * @return String intervalo
	 */
	public String getIntervalo() {
		return intervalo;
	}

	/**
	 * Introducir intervalo
	 * 
	 * @param intervalo
	 *            String intervalo
	 */
	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}

	/**
	 * Devuelve anotacion
	 * 
	 * @return String anotacion
	 */
	public String getAnotacion() {
		return anotacion;
	}

	/**
	 * Introducir anotacion
	 * 
	 * @param anotacion
	 *            String
	 */
	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	/**
	 * Devuelve curso
	 * 
	 * @return Curso curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * Introducir curso
	 * 
	 * @param curso
	 *            Curso curso
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "fecha=" + fecha + ", intervalo=" + intervalo;
	}

}
