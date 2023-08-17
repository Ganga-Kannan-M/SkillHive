package com.ust.skillhive.skillhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.Enrollment;
import com.ust.skillhive.skillhive.entity.User;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
	List<Enrollment> findByEnrolledCourseId(Long courseId);
    List<Enrollment> findByUserId(Long userId);
    
}
