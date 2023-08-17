package com.ust.skillhive.skillhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.User;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	Course findByTitle(String title);
}
