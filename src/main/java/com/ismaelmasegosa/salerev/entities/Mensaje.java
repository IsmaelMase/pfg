package com.ismaelmasegosa.salerev.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mensajes")
public class Mensaje {

	@Id
	public String id;

	@DBRef
	public Usuario emisor;

	@DBRef
	public List<Usuario> receptor;

	public String cuerpo;

	public String tipo;

	public String fecha;

	public boolean leido;

	public Mensaje(String id, Usuario emisor, List<Usuario> receptor, String cuerpo, String tipo, String fecha,
			boolean leido) {
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.cuerpo = cuerpo;
		this.tipo = tipo;
		this.fecha = fecha;
		this.leido = leido;
	}

	public Mensaje() {
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
