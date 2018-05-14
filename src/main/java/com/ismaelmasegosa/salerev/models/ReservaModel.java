package com.ismaelmasegosa.salerev.models;

import java.util.ArrayList;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.entities.Usuario;

public class ReservaModel {

	public String id;

	public Usuario usuario;

	public Recurso recurso;

	public Curso curso;

	public ArrayList<String> fechas_reservas;

	public ArrayList<String> intervalos_reservas;

	public String anotacion;

	public ReservaModel(String id, Usuario usuario, Recurso recurso, ArrayList<String> fechas_reservas,
			ArrayList<String> intervalos_reservas, String anotacion, Curso curso) {
		this.id = id;
		this.usuario = usuario;
		this.recurso = recurso;
		this.fechas_reservas = fechas_reservas;
		this.intervalos_reservas = intervalos_reservas;
		this.anotacion = anotacion;
		this.curso = curso;
	}

	public ReservaModel() {
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

	public ArrayList<String> getFechas_reservas() {
		return fechas_reservas;
	}

	public void setFechas_reservas(ArrayList<String> fechas_reservas) {
		this.fechas_reservas = fechas_reservas;
	}

	public ArrayList<String> getIntervalos_reservas() {
		return intervalos_reservas;
	}

	public void setIntervalos_reservas(ArrayList<String> intervalos_reservas) {
		this.intervalos_reservas = intervalos_reservas;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
