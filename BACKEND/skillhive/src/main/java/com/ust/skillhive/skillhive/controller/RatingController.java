package com.ust.skillhive.skillhive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.Rating;
import com.ust.skillhive.skillhive.entity.User;
import com.ust.skillhive.skillhive.exception.UserNotFoundException;
import com.ust.skillhive.skillhive.service.RatingService;
import com.ust.skillhive.skillhive.service.UserService;

@RestController

@RequestMapping("/reviews")

public class RatingController {

	@Autowired
	private RatingService reviewService;
	@Autowired
	private UserService userService;

	@GetMapping

	public List<Rating> getAllReviews() {

		return reviewService.getAllRatings();

	}

	@GetMapping("/{id}")

	public Rating getReviewById(@PathVariable Long id) {

		return reviewService.getRatingById(id);

	}

	@PostMapping

	public Rating createReview(@RequestParam Long userId, @RequestParam Long courseId,

			@RequestParam int rating, @RequestParam String content) {

		return reviewService.createRating(userId, courseId, rating, content);

	}

	@DeleteMapping("/{id}")

	public void deleteReview(@PathVariable Long id) {

		reviewService.deleteRating(id);

	}
	
	 @GetMapping("/course/{courseId}")
	    public List<Rating> getRatingsForCourse(@PathVariable Long courseId) {
	        Course course = new Course();
	        course.setId(courseId); // Assuming you have a method to fetch a course by ID
	        return reviewService.getRatingsForCourse(course);
	    }
	 @GetMapping("/user/{userId}")
	    public List<Rating> findRatingsByUser(@PathVariable Long userId) {
	        User user = userService.read(userId);
	        if (user == null) {
	            // Handle user not found error
	        	throw new UserNotFoundException("User not found");
	        }
	        
	        return reviewService.findRatingsByUser(user);
	    }

}
