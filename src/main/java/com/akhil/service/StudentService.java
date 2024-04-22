package com.akhil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;

import com.akhil.model.Students;
import com.akhil.repo.IStudentRepo;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentRepo repo;

	@Override
	public String savingData(Students student) {
		return "Data saved with Name: "+repo.save(student).getsName();
	}

	@Override
	public List<Students> fetchingData() {
		return repo.findAll();
	}

}
