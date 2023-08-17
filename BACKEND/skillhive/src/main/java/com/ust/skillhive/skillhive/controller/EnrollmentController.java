package com.ust.skillhive.skillhive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.Enrollment;
import com.ust.skillhive.skillhive.entity.User;
import com.ust.skillhive.skillhive.service.CourseService;
import com.ust.skillhive.skillhive.service.EnrollmentService;
import com.ust.skillhive.skillhive.service.UserService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
   

 

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

 

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

 

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

 

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

 

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
    
    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsForCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsForCourse(courseId);
    }

    @GetMapping("/user/{userId}")
    public List<Enrollment> getEnrollmentsByUser(@PathVariable Long userId) {
        return enrollmentService.getEnrollmentsByUser(userId);
    }
    
}