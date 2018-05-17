package com.ismaelmasegosa.salerev.models;

import java.util.List;

public class HorarioModel {

	public String id;

	public String nombre;

	public List<String> intervalos;

	public HorarioModel(String nombre, List<String> intervalos) {
		this.nombre = nombre;
		this.intervalos = intervalos;
	}

	public HorarioModel() {
	}

	public List<String> getIntervalos() {
		return intervalos;
	}

	public void setIntervalos(List<String> intervalos) {
		this.intervalos = intervalos;
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

	@Override
	public String toString() {
		return "HorarioModel [id=" + id + ", nombre=" + nombre + ", intervalos=" + intervalos + "]";
	}

}
