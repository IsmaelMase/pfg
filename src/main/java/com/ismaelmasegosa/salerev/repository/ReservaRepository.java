package com.ismaelmasegosa.salerev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.entities.Usuario;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

	public List<Reserva> findByUsuario(Optional<Usuario> optional);
	
	public List<Reserva> findByCurso(Optional<Curso> optional);
}
