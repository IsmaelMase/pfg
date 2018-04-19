package com.ismaelmasegosa.salerev.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Curso;

@Repository("cursoRepository")
public interface CursoRepository extends MongoRepository<Curso, String> {

}
