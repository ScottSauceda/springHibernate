package com.ga.service;

import org.springframework.stereotype.Repository;

import com.ga.entity.UserProfile;

@Repository
public interface UserProfileService {
	
	public UserProfile createUserProfile(String username, UserProfile newProfile);
	
	public UserProfile getUserProfile(String username);

}