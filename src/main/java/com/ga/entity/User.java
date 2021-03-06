package com.ga.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
public User() {}

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile;
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	@ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "user_role_id", nullable = false)
	private UserRole userRole;
	    
	public UserRole getUserRole() { return userRole; }
	
	public void setUserRole(UserRole userRole) { this.userRole = userRole; }
	
	 @ManyToMany(fetch = FetchType.LAZY,
             cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
 @JoinTable(name = "user_course",
         joinColumns = {@JoinColumn(name = "user_id")},
         inverseJoinColumns = @JoinColumn(name = "course_id"))
 private List<Course> courses;
 
 public List<Course> getCourses() { return courses; }

 public void setCourses(List<Course> courses) { this.courses = courses; }
 
 
 public List<Course> addCourse(Course course) {
     if(courses == null)
         courses = new ArrayList<>();
     
	courses.add(course);

     return courses;
 }

}
