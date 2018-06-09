package com.ismaelmasegosa.salerev.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Document(collection = "cursos")
public class Curso {

	@Id
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
	public Curso(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Contructor por defecto
	 */
	public Curso() {
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

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + "]";
	}

}
