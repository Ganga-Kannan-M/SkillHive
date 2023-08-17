package com.ust.skillhive.skillhive.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.Rating;
import com.ust.skillhive.skillhive.entity.User;
import com.ust.skillhive.skillhive.repository.RatingRepository;

@Service
	public class RatingService {
	    private final RatingRepository ratingRepository;
	    private final UserService userService;
	    private final CourseService courseService;

	 

	    @Autowired
	    public RatingService(RatingRepository ratingRepository, UserService userService, CourseService courseService) {
	        this.ratingRepository = ratingRepository;
	        this.userService = userService;
	        this.courseService = courseService;
	    }

	 

	    public List<Rating> getAllRatings() {
	        return ratingRepository.findAll();
	    }

	 

	    public Rating getRatingById(Long ratingId) {
	        return ratingRepository.findById(ratingId).orElse(null);
	    }

	 

	    public Rating createRating(Long userId, Long courseId, int ratingValue, String review) {
	        User user = userService.read(userId);
	        Course course = courseService.getCourseById(courseId);

	 

	        if (user != null && course != null) {
	            Rating rating = new Rating();
	            rating.setUser(user);
	            rating.setCourse(course);
	            rating.setRating(ratingValue);
	            rating.setReview(review);
	            rating.setTimestamp(LocalDateTime.now());

	 

	            return ratingRepository.save(rating);
	        }

	 

	        return null;
	    }

	 

	    public void deleteRating(Long ratingId) {
	        ratingRepository.deleteById(ratingId);
	    }
	    
	    public List<Rating> getRatingsForCourse(Course course) {
	        return ratingRepository.findByCourse(course);
	    }
	    public List<Rating> findRatingsByUser(User user) {
	        return ratingRepository.findByUser(user);
	    }
	}


