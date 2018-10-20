package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
@RestController
@RequestMapping("/api")
public class VoteResource {
	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody User newUser) {
		userRepository.save(newUser);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestBody User user) {
		userRepository.findByLogin(user.getLogin());

	}
}
