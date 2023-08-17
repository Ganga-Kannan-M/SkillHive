package com.ust.skillhive.skillhive.entity;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

 

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

 

    private int rating;
    private String review;
    private LocalDateTime timestamp;

 

    // Constructors, getters, setters, etc.

 

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

 

    public Course getCourse() {
        return course;
    }

 

    public void setCourse(Course course) {
        this.course = course;
    }

 

    public int getRating() {
        return rating;
    }

 

    public void setRating(int rating) {
        this.rating = rating;
    }

 

    public String getReview() {
        return review;
    }

 

    public void setReview(String review) {
        this.review = review;
    }

 

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

 

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}


