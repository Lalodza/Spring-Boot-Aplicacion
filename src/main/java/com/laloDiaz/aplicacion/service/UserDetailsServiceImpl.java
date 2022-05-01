package com.laloDiaz.aplicacion.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laloDiaz.aplicacion.entity.Role;
import com.laloDiaz.aplicacion.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.laloDiaz.aplicacion.entity.User appUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido"));
		
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
		for(Role role: appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
            grantList.add(grantedAuthority);
		}
		
		UserDetails user = (UserDetails) new User(username,appUser.getPassword(),grantList);
		
		return user;
	}

}
