package com.ismaelmasegosa.salerev.models;

import java.util.ArrayList;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.entities.Usuario;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public class ReservaModel {

	public String id;

	public Usuario usuario;

	public Recurso recurso;

	public Curso curso;

	public ArrayList<String> fechas_reservas;

	public ArrayList<String> intervalos_reservas;

	public String anotacion;

	/**
	 * Constructor parametrizado
	 * 
	 * @param id
	 *            String id
	 * @param usuario
	 *            Usuario usuario
	 * @param recurso
	 *            Recurso recurso
	 * @param fechas_reservas
	 *            ArrayList<String> fechas de las reservas
	 * @param intervalos_reservas
	 *            ArrayList<String> intervalos de reservas
	 * @param anotacion
	 *            String anotacion
	 * @param curso
	 *            Curso curso
	 */
	public ReservaModel(String id, Usuario usuario, Recurso recurso, ArrayList<String> fechas_reservas,
			ArrayList<String> intervalos_reservas, String anotacion, Curso curso) {
		this.id = id;
		this.usuario = usuario;
		this.recurso = recurso;
		this.fechas_reservas = fechas_reservas;
		this.intervalos_reservas = intervalos_reservas;
		this.anotacion = anotacion;
		this.curso = curso;
	}

	/**
	 * Constructor por defecto
	 */
	public ReservaModel() {
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
	 * Devuelve fechas reservas
	 * 
	 * @return ArrayList<String> fechas reservas
	 */
	public ArrayList<String> getFechas_reservas() {
		return fechas_reservas;
	}

	/**
	 * Introducir fechas reservas
	 * 
	 * @param fechas_reservas
	 *            ArrayList<String> fechas
	 */
	public void setFechas_reservas(ArrayList<String> fechas_reservas) {
		this.fechas_reservas = fechas_reservas;
	}

	/**
	 * Devuelve intervalos reservas
	 * 
	 * @return ArrayList<String> intervalos reservas
	 */
	public ArrayList<String> getIntervalos_reservas() {
		return intervalos_reservas;
	}

	/**
	 * Introducir intervalos reservas
	 * 
	 * @param intervalos_reservas
	 *            ArrayList<String> intervalos
	 */
	public void setIntervalos_reservas(ArrayList<String> intervalos_reservas) {
		this.intervalos_reservas = intervalos_reservas;
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

}
