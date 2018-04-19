package com.ismaelmasegosa.salerev.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismaelmasegosa.salerev.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public Optional<User> findByDni(String dni);
	
}
