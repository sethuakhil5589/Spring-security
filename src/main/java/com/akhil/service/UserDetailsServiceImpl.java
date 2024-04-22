package com.akhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akhil.model.Users;
import com.akhil.repo.IUserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IUserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findByUserName(username);
		System.out.println(user);
		if(user==null) {
			System.out.println("User 404");
			throw new UsernameNotFoundException("user 404");
		}
		return new UserDetailsImpl(user);
	}

}
