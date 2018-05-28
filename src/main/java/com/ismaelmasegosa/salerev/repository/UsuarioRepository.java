package com.ismaelmasegosa.salerev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	public Optional<Usuario> findByDni(String dni);

	public Usuario findByEmail(String email);

	public List<Usuario> findByRol(String rol);

	public List<Usuario> findByRolAndEstado(String rol, boolean estado);

}
