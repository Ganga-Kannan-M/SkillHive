package com.ust.skillhive.skillhive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.Enrollment;
import com.ust.skillhive.skillhive.entity.User;
import com.ust.skillhive.skillhive.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

 

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

 

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

 

    public Enrollment getEnrollmentById(Long enrollmentId) {
        return enrollmentRepository.findById(enrollmentId).orElse(null);
    }

 

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

 

    public void deleteEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
    public List<Enrollment> getEnrollmentsForCourse(Long courseId) {
        return enrollmentRepository.findByEnrolledCourseId(courseId);
    }

    public List<Enrollment> getEnrollmentsByUser(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }
   
//    public String getEnrollmentStatus(User user, Course course) {
//        Enrollment enrollment = enrollmentRepository.findByUserAndEnrolledCourse(user, course);
//        if (enrollment == null) {
//            return "Not Enrolled";
//        } else if (enrollment.isCompleted()) {
//            return "Completed";
//        } else {
//            return "Active";
//        }
//    } 
}