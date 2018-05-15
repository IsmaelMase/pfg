package com.ismaelmasegosa.salerev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Mensaje;
import com.ismaelmasegosa.salerev.entities.Usuario;

@Repository("mensajeRepository")
public interface MensajeRepository extends MongoRepository<Mensaje, String> {

	public List<Mensaje> findByLeido(boolean leido);

	public List<Mensaje> findByReceptor(Optional<Usuario> optional);

}
