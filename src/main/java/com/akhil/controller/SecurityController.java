package com.akhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.model.Students;
import com.akhil.model.Users;
import com.akhil.service.StudentService;
import com.akhil.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/hello")
	public String helloMessage(HttpServletRequest response) {
		return "Hello World...: "+response.getSession().getId();
	}
	
	@GetMapping("/about")
	public String aboutMessage(HttpServletRequest response) {
		return "Sethu Akhil Katta: "+response.getSession().getId();
	}
	
	@PostMapping("/save")
	public String savingData(@RequestBody Students student) {
		return service.savingData(student);
	}
	
	@PostMapping("/fetch")
	public List<Students> fetchingData(){
		return service.fetchingData();
	}
	
	@GetMapping("/csrf")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<Object> registerData(@RequestBody Users user){
		return new ResponseEntity<>(userService.savingUsers(user),HttpStatus.OK);
	}
	
}
