package com.ismaelmasegosa.salerev.models;

import java.time.LocalDate;
import java.util.List;

public class HorarioModel {

	public String id;

	public String nombre;

	public List<String> intervalos;

	public LocalDate fecha_max;

	public HorarioModel(String id, String nombre, List<String> intervalos, LocalDate fecha_max) {
		this.id = id;
		this.nombre = nombre;
		this.intervalos = intervalos;
		this.fecha_max = fecha_max;
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

	public LocalDate getFecha_max() {
		return fecha_max;
	}

	public void setFecha_max(LocalDate fecha_max) {
		this.fecha_max = fecha_max;
	}

	@Override
	public String toString() {
		return "HorarioModel [id=" + id + ", nombre=" + nombre + ", intervalos=" + intervalos + "]";
	}

}
