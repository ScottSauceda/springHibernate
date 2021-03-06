package com.ga.service;

import java.util.List;

import com.ga.entity.User;

public interface UserService {

	public List<User> listUsers();
	
	public User signup(User user);
	
	public Long login(User user);
	
	public User updateUser(User user, Long userId);
	
	public Long deleteUser(Long userId);
	
	public User addCourse(String username, int courseId);
		
}