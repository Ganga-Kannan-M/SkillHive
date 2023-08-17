package com.ust.skillhive.skillhive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.User;
import com.ust.skillhive.skillhive.repository.CourseRepository;
import com.ust.skillhive.skillhive.repository.UserRepository;

@Service
public class CourseService {
	
	
	@Autowired
    private  CourseRepository courseRepository;
	
 

  
 

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

 

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

 

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

 

    public Course updateCourse(Long courseId, Course course) {
        Course existingCourse = courseRepository.findById(courseId).orElse(null);
        if (existingCourse != null) {
            existingCourse.setTitle(course.getTitle());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setPrice(course.getPrice());
            // Update other properties as needed
            return courseRepository.save(existingCourse);
        }
        return null;
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
//    public List<User> getInstructorsByCourseTitle(String courseTitle) {
//        return courseRepository.findInstructorByTitle(courseTitle);
//    }
    
    
    public User findInstructorForCourse(String courseTitle) {
        Course course = courseRepository.findByTitle(courseTitle);
        if (course != null) {
            return course.getInstructor();
        }
        return null; // Course not found
    }
 
}