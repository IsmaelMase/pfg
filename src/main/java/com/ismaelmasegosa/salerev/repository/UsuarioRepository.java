package com.ismaelmasegosa.salerev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.entities.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	/**
	 * Buscar por dni
	 * 
	 * @param dni
	 *            String DNI
	 * @return Optional<Usuario> usuario
	 */
	public Optional<Usuario> findByDni(String dni);

	/**
	 * Buscar por email
	 * 
	 * @param email
	 *            String email
	 * @return Usuario usuario
	 */
	public Usuario findByEmail(String email);

	/**
	 * Buscar por rol
	 * 
	 * @param rol
	 *            String rol
	 * @return List<Usuario> usuarios
	 */
	public List<Usuario> findByRol(String rol);

	/**
	 * Buscar por curso
	 * 
	 * @param curso
	 *            Curso curso
	 * @return List<Usuario> usuarios
	 */
	public List<Usuario> findFirstByCursos(Curso curso);

	/**
	 * Buscar por rol y estado
	 * 
	 * @param rol
	 *            String rol
	 * @param estado
	 *            boolean estado
	 * @return List<Usuario> usuarios
	 */
	public List<Usuario> findByRolAndEstado(String rol, boolean estado);

}
