package com.ismaelmasegosa.salerev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.entities.Usuario;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

	public List<Reserva> findByUsuarioAndFechaContains(Optional<Usuario> optional, String s);

	public List<Reserva> findByRecurso(Recurso recurso);

	public List<Reserva> findFirstByRecurso(Recurso recurso);

	public List<Reserva> findByIntervaloAndRecurso(String intervalo, Optional<Recurso> r);

	public List<Reserva> findByRecursoAndFechaContains(Optional<Recurso> r, String s);

	public List<Reserva> findByRecursoAndFechaAndIntervalo(Recurso r, String fecha, String hora);

	// public List<String>
	// findDistinctFecha_reservaByIntervalo_reservaAndRecurso(List<String> horas,
	// Recurso recurso);
}
