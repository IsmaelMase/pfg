package com.ismaelmasegosa.salerev.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Recurso;

@Repository("recursoRepository")
public interface RecursoRepository extends MongoRepository<Recurso, String> {

	public List<Recurso> findByTipo(String tipo);
	
}
