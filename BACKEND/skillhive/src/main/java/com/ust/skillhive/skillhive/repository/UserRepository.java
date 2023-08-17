package com.ust.skillhive.skillhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>
	
{
	@Query("SELECT e.enrolledCourse FROM Enrollment e WHERE e.user.id = :userId")
    List<Course> findEnrolledCoursesById(Long userId);
}
