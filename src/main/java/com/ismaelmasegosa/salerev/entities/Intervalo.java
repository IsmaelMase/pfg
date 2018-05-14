package com.ismaelmasegosa.salerev.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "intervalos")
public class Intervalo {

	@Id
	public String id;

	public List<String> intervalos;

	public Intervalo(List<String> intervalos) {
		this.intervalos = intervalos;
	}

	public Intervalo() {
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

}
