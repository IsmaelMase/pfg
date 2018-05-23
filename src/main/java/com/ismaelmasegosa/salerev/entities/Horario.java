package com.ismaelmasegosa.salerev.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "intervalos")
public class Horario {

	@Id
	public String id;

	public String nombre;

	public List<String> intervalos;

	public Horario(String nombre, List<String> intervalos) {
		this.nombre = nombre;
		this.intervalos = intervalos;
	}

	public Horario() {
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
		return "Horario [id=" + id + ", nombre=" + nombre + ", intervalos=" + intervalos + "]";
	}

}