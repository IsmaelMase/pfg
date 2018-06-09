package com.ismaelmasegosa.salerev.models;

import com.ismaelmasegosa.salerev.entities.Horario;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public class RecursoModel {

	public String id;

	public String nombre;

	public String tipo;

	public String datos;

	public String incidencia;

	public int capacidad;

	public Horario intervalo;

	public String imagen;

	/**
	 * Constructor parametrizado
	 * 
	 * @param id
	 *            String id
	 * @param nombre
	 *            String nombre
	 * @param tipo
	 *            String tipo
	 * @param datos
	 *            String datos
	 * @param incidencia
	 *            String incidencia
	 * @param capacidad
	 *            ing capacidad
	 * @param intervalo
	 *            Horario horario
	 * @param imagen
	 *            String imagen
	 */
	public RecursoModel(String id, String nombre, String tipo, String datos, String incidencia, int capacidad,
			Horario intervalo, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.datos = datos;
		this.incidencia = incidencia;
		this.capacidad = capacidad;
		this.intervalo = intervalo;
		this.imagen = imagen;
	}

	/**
	 * Constructor por defecto
	 */
	public RecursoModel() {
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
	 * Devuelve nombre
	 * 
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Introducir nombre
	 * 
	 * @param nombre
	 *            String nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve tipo
	 * 
	 * @return String tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Introducir tipo
	 * 
	 * @param String
	 *            tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve datos
	 * 
	 * @return String datos
	 */
	public String getDatos() {
		return datos;
	}

	/**
	 * Introducir datos
	 * 
	 * @param datos
	 *            String datos
	 */
	public void setDatos(String datos) {
		this.datos = datos;
	}

	/**
	 * Devuelve incidencia
	 * 
	 * @return String incidencia
	 */
	public String getIncidencia() {
		return incidencia;
	}

	/**
	 * Introducir incidencia
	 * 
	 * @param incidencia
	 *            String incidencia
	 */
	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	/**
	 * Devuelve capacidad
	 * 
	 * @return int capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Introducir capacidad
	 * 
	 * @param capacidad
	 *            int capacidad
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Devuelve horario
	 * 
	 * @return Horario horario
	 */
	public Horario getIntervalo() {
		return intervalo;
	}

	/**
	 * Introducir horario
	 * 
	 * @param intevalo
	 *            Horario horario
	 */
	public void setIntervalo(Horario intevalo) {
		this.intervalo = intevalo;
	}

	/**
	 * Devuelve nombre imagen
	 * 
	 * @return String imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Introducir imagen
	 * 
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
