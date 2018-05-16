package com.ismaelmasegosa.salerev.models;

import java.util.List;

import com.ismaelmasegosa.salerev.entities.Usuario;

public class MensajeModel {

	String id;

	Usuario emisor;

	List<Usuario> receptor;

	String cuerpo;

	String tipo;

	String fecha;

	boolean leido;

	public MensajeModel(String id, Usuario emisor, List<Usuario> receptor, String cuerpo, String tipo, String fecha,
			boolean leido) {
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.cuerpo = cuerpo;
		this.tipo = tipo;
		this.fecha = fecha;
		this.leido = leido;
	}

	public MensajeModel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public List<Usuario> getReceptor() {
		return receptor;
	}

	public void setReceptor(List<Usuario> receptor) {
		this.receptor = receptor;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
