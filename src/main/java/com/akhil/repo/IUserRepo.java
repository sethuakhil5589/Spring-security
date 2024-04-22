package com.akhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.model.Users;

public interface IUserRepo extends JpaRepository<Users, String> {
	Users findByUserName(String userName);
}
