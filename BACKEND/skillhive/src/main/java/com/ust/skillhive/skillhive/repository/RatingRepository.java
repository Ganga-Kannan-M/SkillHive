package com.ust.skillhive.skillhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.Rating;
import com.ust.skillhive.skillhive.entity.User;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long>{
	 List<Rating> findByCourse(Course course);
	 List<Rating> findByUser(User user);

}
