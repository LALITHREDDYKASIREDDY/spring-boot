package com.example.LearningPortal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearningPortal.model.User;
import com.example.LearningPortal.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ArrayList<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable("userId") int id) {
		return userService.getUseById(id);
	}

	@PostMapping("/signin")
	public User addUser(@RequestBody User user) {
		System.out.println("in signin");
		return userService.addUser(user);
	}

	@PutMapping("/users/{userId}")
	public User updateUserById(@PathVariable("userId") int id, @RequestBody User user) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUserById(@PathVariable("userId") int id) {
		userService.deleteUserById(id);
	}
}
