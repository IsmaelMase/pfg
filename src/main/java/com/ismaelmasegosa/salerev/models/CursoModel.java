package com.ismaelmasegosa.salerev.models;

public class CursoModel {

	public String id;

	public String nombre;

	public CursoModel(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public CursoModel() {
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

}
