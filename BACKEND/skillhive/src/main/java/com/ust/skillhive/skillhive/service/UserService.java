package com.ust.skillhive.skillhive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.skillhive.skillhive.entity.Course;
import com.ust.skillhive.skillhive.entity.User;
import com.ust.skillhive.skillhive.exception.UserAlreadyExistException;
import com.ust.skillhive.skillhive.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository ur;
	
	public User create(User user) {
		
		User temp = null;
		if(user.getId()!=null)
			temp=read(user.getId());
		if(temp!=null)
		{
			//user already exists
			throw new UserAlreadyExistException("There is already an user with id: "+user.getId());
		}		
		return ur.save(user);
	}
	public List<User> read() {
		return ur.findAll();
	}
	public User read(Long id) {
		Optional<User> temp = ur.findById(id);
		User user=null;
		if(temp!=null)
		{
			user=temp.get();
		}
		return user;
	}
	public User update(User user) {
		User temp = read(user.getId());
		if(temp!=null)
		{
			temp=user;
			ur.save(temp);
		}
		return temp;
	}
	public User delete(Long id) {
		User user=read(id);
		if(user!=null)
		{
			ur.delete(user);
		}
		return user;
	}
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = read(Long.parseLong(username));
//		
//		
//		return user;
//	}
	
	public List<Course> findEnrolledCourses(Long userId) {
        return ur.findEnrolledCoursesById(userId);
    }

}
