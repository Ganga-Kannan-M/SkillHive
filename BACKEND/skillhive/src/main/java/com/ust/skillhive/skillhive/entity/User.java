package com.ust.skillhive.skillhive.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name = "USERS")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String password;	
	private String name;
	private String email;
	private String phone;
	private String qualification;
//	@Enumerated(EnumType.STRING) private Role role; 
	private String role;
//	@ManyToMany @JoinTable(name = "user_course_enrollment", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id")) 
//	private List<Course> enrolledCourses;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
    private List<Enrollment> enrollments = new ArrayList<>();
	
	public User()
	{
		
	}

	public User(Long id, String password, String name, String email, String phone, String qualification, String role,
			List<Enrollment> enrollments) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.qualification = qualification;
		this.role = role;
		this.enrollments = enrollments;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", qualification=" + qualification + ", role=" + role + ", enrollments=" + enrollments + "]";
	}
	
}

