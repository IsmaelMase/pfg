package com.ismaelmasegosa.salerev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.entities.Usuario;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

	/**
	 * Bucar por usuario
	 * 
	 * @param usuario
	 *            Usuario usuario
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> findByUsuario(Usuario usuario);

	/**
	 * buscar por usuario y fecha
	 * 
	 * @param usuario
	 *            Usuario usuario
	 * @param fecha
	 *            String fecha
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> findByUsuarioAndFechaContains(Optional<Usuario> usuario, String fecha);

	/**
	 * Buscar por recurso
	 * 
	 * @param recurso
	 *            Recurso recurso
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> findByRecurso(Recurso recurso);

	/**
	 * Buscar el primero por recurso
	 * 
	 * @param recurso
	 *            Recurso recurso
	 * @return
	 */
	public List<Reserva> findFirstByRecurso(Recurso recurso);

	/**
	 * Buscar por intevalo y recurso
	 * 
	 * @param intervalo
	 *            String intervalo
	 * @param r
	 *            Recurso recurso
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> findByIntervaloAndRecurso(String intervalo, Optional<Recurso> r);

	/**
	 * Buscar por fecha y recurso
	 * 
	 * @param fecha
	 *            String fecha
	 * @param r
	 *            Recurso recurso
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> findByRecursoAndFechaContains(Optional<Recurso> r, String fecha);

	/**
	 * Buscar por recurso fecha y hora
	 * 
	 * @param r
	 *            Recurso recurso
	 * @param fecha
	 *            String fecha
	 * @param hora
	 *            String hora
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> findByRecursoAndFechaAndIntervalo(Recurso r, String fecha, String hora);

	/**
	 * Buscar por usuario fecha y hora
	 * 
	 * @param u
	 *            Usuario Usuario
	 * @param fecha
	 *            String fecha
	 * @param hora
	 *            String hora
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> findByUsuarioAndFechaAndIntervalo(Usuario u, String fecha, String hora);

}
