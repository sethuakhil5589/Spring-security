package com.akhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.akhil.model.Users;
import com.akhil.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo repo;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	@Override
	public Users savingUsers(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

}
