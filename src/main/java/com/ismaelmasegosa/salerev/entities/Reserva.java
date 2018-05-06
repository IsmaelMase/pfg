package com.ismaelmasegosa.salerev.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservas")
public class Reserva {

	@Id
	public String id;

	@DBRef
	public Usuario usuario;

	@DBRef
	public Recurso recurso;

	public String fecha;

	public String intervalo;

	public String anotacion;

	public Reserva(String id, Usuario usuario, Recurso recurso, String fecha_reserva, String intervalo_reserva,
			String anotacion) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.recurso = recurso;
		this.fecha = fecha_reserva;
		this.intervalo = intervalo_reserva;
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

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

}
