package com.ismaelmasegosa.salerev.models;

import com.ismaelmasegosa.salerev.entities.Horario;

public class RecursoModel {

	public String id;

	public String nombre;

	public String tipo;

	public String datos;

	public String incidencia;

	public int capacidad;

	public Horario intervalo;

	public String imagen;

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

	public RecursoModel() {
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Horario getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Horario intevalo) {
		this.intervalo = intevalo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
