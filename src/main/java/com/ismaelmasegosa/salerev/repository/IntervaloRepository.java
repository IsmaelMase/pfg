package com.ismaelmasegosa.salerev.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Intervalo;

@Repository("intervaloRepository")
public interface IntervaloRepository extends MongoRepository<Intervalo, String>{

}
