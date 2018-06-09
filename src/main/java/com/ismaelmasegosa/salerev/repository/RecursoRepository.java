package com.ismaelmasegosa.salerev.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Horario;
import com.ismaelmasegosa.salerev.entities.Recurso;

@Repository("recursoRepository")
public interface RecursoRepository extends MongoRepository<Recurso, String> {

	/**
	 * Buscar aula o recurso por el tipo
	 * 
	 * @param tipo
	 *            String tipo
	 * @return List<Recurso> recursos o aulas
	 */
	public List<Recurso> findByTipo(String tipo);

	/**
	 * Buscar el primero por intervalo
	 * 
	 * @param h
	 *            Horario horario
	 * @return List<Recurso> recursos o aulas
	 */
	public List<Recurso> findFirstByIntervalo(Horario h);

}
