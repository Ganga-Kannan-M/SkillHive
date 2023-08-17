package com.ust.skillhive.skillhive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.User;
import com.ust.skillhive.skillhive.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
    private  CourseService courseService;
	 

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

 

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

 

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

 

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

 

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
    
//    @GetMapping("/{courseTitle}/instructors")
//    public List<User> getInstructorsByCourseTitle(@PathVariable String courseTitle) {
//        return courseService.getInstructorsByCourseTitle(courseTitle);
//    }
    
    @GetMapping("/instructor/{courseTitle}")
    public User getInstructorForCourse(@PathVariable String courseTitle) {
        return courseService.findInstructorForCourse(courseTitle);
    }

}


