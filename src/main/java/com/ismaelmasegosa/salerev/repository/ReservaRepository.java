package com.ismaelmasegosa.salerev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.entities.Usuario;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

	public List<Reserva> findByUsuario(Usuario usuario);

	public List<Reserva> findByRecurso(Recurso recurso);

	public List<Reserva> findByIntervaloAndRecurso(String intervalo, Optional<Recurso> r);

	public List<Reserva> findByRecurso(Optional<Recurso> r);

	// public List<String>
	// findDistinctFecha_reservaByIntervalo_reservaAndRecurso(List<String> horas,
	// Recurso recurso);
}
