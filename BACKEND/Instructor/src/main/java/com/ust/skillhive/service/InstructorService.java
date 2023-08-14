package com.ust.skillhive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.skillhive.exception.InstructorNotFoundException;
import com.ust.skillhive.model.Instructor;
import com.ust.skillhive.repository.InstructorRepository;


@Service
public class InstructorService {
	
	private final InstructorRepository instructorRepository;
	
	@Autowired 
    public InstructorService(InstructorRepository instructorRepository) {
		super();
		this.instructorRepository = instructorRepository;
	}
	
	
	 public Instructor createInstructor(Instructor instructor) {
	        return instructorRepository.save(instructor);
	    }
	public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }
    public Instructor getInstructorById(Long instructorId) {
        // Retrieve the user from the database by ID
        return instructorRepository.findById(instructorId)
        		.orElseThrow(() -> new InstructorNotFoundException("Instructor not found with ID: " + instructorId));
    }
    
    public Instructor updateInstructor(Long instructorId, Instructor updatedInstructor) {
        // Retrieve the user from the database by ID
    	Instructor user = instructorRepository.findById(instructorId)
    			.orElseThrow(() -> new InstructorNotFoundException("Instructor not found with ID: " + instructorId));
        
    	user.setInstructorUsername(updatedInstructor.getInstructorUsername());
       user.setInstructorEmail(updatedInstructor.getInstructorEmail());
       user.setInstructorPassword(updatedInstructor.getInstructorPassword());
       user.setCourseId(updatedInstructor.getCourseId());
       user.setInstructorQualification(updatedInstructor.getInstructorQualification());
        
 
        // Save the updated user in the database
        return instructorRepository.save(user);
        
       
    }

   
	
	
	
	

}
