package com.laloDiaz.aplicacion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laloDiaz.aplicacion.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
//	public Iterable<User> findAllByStatus(String status);
//	public Set<User> findByUsername(String username);
}
