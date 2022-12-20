package com.sinchan.hibernateproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sinchan.hibernateproject.entity.User;
import com.sinchan.hibernateproject.exceptions.ResourceNotFoundException;
import com.sinchan.hibernateproject.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByUserName(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user name", username));
		return user;
	}

}
