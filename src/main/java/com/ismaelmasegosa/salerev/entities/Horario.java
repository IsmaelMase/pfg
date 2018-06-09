package com.ismaelmasegosa.salerev.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Document(collection = "intervalos")
public class Horario {

	@Id
	public String id;

	public String nombre;

	public List<String> intervalos;

	public String fecha_max;

	/**
	 * Constructor parametrizado
	 * 
	 * @param id
	 *            String id
	 * @param nombre
	 *            String nombre
	 * @param intervalos
	 *            String intervalos
	 * @param fecha_max
	 *            String fecha_max
	 */
	public Horario(String id, String nombre, List<String> intervalos, String fecha_max) {
		this.id = id;
		this.nombre = nombre;
		this.intervalos = intervalos;
		this.fecha_max = fecha_max;
	}

	/**
	 * Constructor por defecto
	 */
	public Horario() {
	}

	/**
	 * Devuelve intervalos
	 * 
	 * @return List<String> intervalos
	 */
	public List<String> getIntervalos() {
		return intervalos;
	}

	/**
	 * Introducir intervalos
	 * 
	 * @param intervalos
	 *            List<String> intervalos
	 */
	public void setIntervalos(List<String> intervalos) {
		this.intervalos = intervalos;
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
	 * Devuelve fecha maxima
	 * 
	 * @return String fecha_max
	 */
	public String getFecha_max() {
		return fecha_max;
	}

	/**
	 * Introducir fecha maxima
	 * 
	 * @param fecha_max
	 *            String fecha_max
	 */
	public void setFecha_max(String fecha_max) {
		this.fecha_max = fecha_max;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", nombre=" + nombre + ", intervalos=" + intervalos + "]";
	}

}
