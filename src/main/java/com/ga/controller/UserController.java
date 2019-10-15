package com.ga.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga.entity.User;
import com.ga.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public List<User> listUsers() {
		return userService.listUsers();
	}
	
	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		return userService.signup(user);
	}
	
	@PostMapping("/login")
	public Long login(@RequestBody User user) {
		return userService.login(user);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable Long userId) {
		return userService.updateUser(user, userId);
	}
	
	@DeleteMapping("/{userId}")
	public Long deleteUser(@PathVariable Long userId) {
		return userService.deleteUser(userId);
	}
	
	@PutMapping("/{username}/course/{courseId}")
    public User addCourse(@PathVariable String username, @PathVariable int courseId) {
        return userService.addCourse(username, courseId);
    }
	
}
