package com.ismaelmasegosa.salerev.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cursos")
public class Curso {

	@Id
	public String id;

	public String nombre;

	@DBRef(lazy = true)
	public List<User> users;

	public Curso(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Curso() {
		super();
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
		return "Curso [id=" + id + ", nombre=" + nombre + ", users=" + users + "]";
	}
	

}
