package com.ust.skillhive.skillhive.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Course_Details")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private Double price;

	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private User instructor;

	@OneToMany(mappedBy = "enrolledCourse")
	@JsonIgnore
	private List<Enrollment> enrollments = new ArrayList<>();

	public Course() {

	}

	public Course(Long id, String title, String description, Double price, User instructor,
			List<Enrollment> enrollments) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.instructor = instructor;
		this.enrollments = enrollments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getInstructor() {
		return instructor;
	}

	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", instructor=" + instructor + ", enrollments=" + enrollments + "]";
	}

}