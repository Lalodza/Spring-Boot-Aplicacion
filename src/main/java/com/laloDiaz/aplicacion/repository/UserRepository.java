package com.laloDiaz.aplicacion.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laloDiaz.aplicacion.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public Optional<User> findByUsername(String username);
//	public Iterable<User> findAllByStatus(String status);
//	public Set<User> findByUsername(String username);
}
