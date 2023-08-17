package com.ust.skillhive.skillhive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_COURSE_ENROLLMENT")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course enrolledCourse;

	public Enrollment() {
		
	}

	public Enrollment(Long id, User user, Course enrolledCourse) {
		super();
		this.id = id;
		this.user = user;
		this.enrolledCourse = enrolledCourse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getEnrolledCourse() {
		return enrolledCourse;
	}

	public void setEnrolledCourse(Course enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", user=" + user + ", enrolledCourse=" + enrolledCourse + "]";
	}
	
    
}