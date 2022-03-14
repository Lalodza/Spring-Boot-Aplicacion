package com.laloDiaz.aplicacion.service;

import com.laloDiaz.aplicacion.entity.User;

public interface UserService {
	
	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;
}
