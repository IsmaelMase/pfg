package com.ismaelmasegosa.salerev.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Mensaje;

@Repository("mensajeRepository")
public interface MensajeRepository extends MongoRepository<Mensaje, String>{

	public List<Mensaje> findByTipo(String tipo);
	
}
