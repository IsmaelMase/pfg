package com.ismaelmasegosa.salerev.entities;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservas")
public class Reserva {

	@Id
	public String id;

	@DBRef
	public Usuario usuario;

	public Date fecha_inicio;

	public Date fecha_fin;

	@DBRef
	public Curso curso;

	public String anotacion;

	public Reserva(String id, Usuario usuario, Date fecha_inicio, Date fecha_fin, Curso curso, String anotacion) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.curso = curso;
		this.anotacion = anotacion;
	}

	public Reserva() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", usuario=" + usuario + ", fecha_inicio=" + fecha_inicio + ", fecha_fin="
				+ fecha_fin + ", curso=" + curso + ", anotacion=" + anotacion + "]";
	}
	
	
}
