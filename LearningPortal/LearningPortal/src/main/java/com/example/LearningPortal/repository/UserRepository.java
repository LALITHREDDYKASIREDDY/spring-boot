package com.example.LearningPortal.repository;

import java.util.ArrayList;

import com.example.LearningPortal.model.User;

public interface UserRepository {
	ArrayList<User> getUsers();

	User getUseById(int id);

	User addUser(User user);

	User updateUser(User user, int id);

	void deleteUserById(int id);

}
