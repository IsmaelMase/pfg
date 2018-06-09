package com.ismaelmasegosa.salerev.models;

/**
 * 
 * @author Ismael Masegosa
 *
 */
public class CursoModel {

	public String id;

	public String nombre;

	/**
	 * Constructor parametrizado
	 * 
	 * @param id
	 *            String id
	 * @param nombre
	 *            String nombre
	 */
	public CursoModel(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Contructor por defecto
	 */
	public CursoModel() {
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
	 * Introducir id;
	 * 
	 * @param id
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

}
