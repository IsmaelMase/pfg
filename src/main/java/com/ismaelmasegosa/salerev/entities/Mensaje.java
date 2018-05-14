package com.ismaelmasegosa.salerev.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mensajes")
public class Mensaje {

	@Id
	String id;

	@DBRef
	Usuario emisor;

	@DBRef
	Usuario receptor;

	String asunto;

	String cuerpo;

	String tipo;

	public Mensaje(String id, Usuario emisor, Usuario receptor, String asunto, String cuerpo, String tipo) {
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.tipo = tipo;
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

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
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

}
