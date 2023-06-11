package com.cglia.hibernate.mappings.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cglia.hibernate.mappings.entity.Course;
import com.cglia.hibernate.mappings.entity.Instructor;
import com.cglia.hibernate.mappings.entity.InstructorDetail;
import com.cglia.hibernate.mappings.exceptionhandling.GlobalNotFoundException;
import com.cglia.hibernate.mappings.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	    private InstructorRepository instructorRepository;

	    @Autowired
	    public InstructorServiceImpl(InstructorRepository instructorRepository) {
	        this.instructorRepository = instructorRepository;
	    }

	    @Override
	    @Transactional
	    public List<Instructor> findAll() {
	        return instructorRepository.findAll();
	    }

	    @Override
	    @Transactional
	    public Instructor findById(int id) {
	        return instructorRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Instructor not found: " + id));
	    }

	    @Override
	    @Transactional
	    public void save(Instructor instructor, InstructorDetail instructorDetail) {
	        instructor.setInstructorDetail(instructorDetail);
	        instructorRepository.save(instructor);
	    }

	    @Override
	    @Transactional
	    public void update(Instructor instructor, int id) {
	        Instructor existingInstructor = findById(id);
	        existingInstructor.setFirstName(instructor.getFirstName());
	        existingInstructor.setLastName(instructor.getLastName());
	        existingInstructor.setEmail(instructor.getEmail());
	        instructorRepository.save(existingInstructor);
	    }

	    @Override
	    @Transactional
	    public void deleteById(int id) {
	        instructorRepository.deleteById(id);
	    }

	    @Override
	    @Transactional
	    public void updateInstructorAndDetail(int instructorId, Instructor updatedInstructor,
	            InstructorDetail updatedInstructorDetail) {
	        Instructor instructor = findById(instructorId);
	        instructor.setFirstName(updatedInstructor.getFirstName());
	        instructor.setLastName(updatedInstructor.getLastName());
	        instructor.setEmail(updatedInstructor.getEmail());
	        instructor.setInstructorDetail(updatedInstructorDetail);
	    }

		@Override
		public List<Course> getAllInstructorCourses(int id) {
			Optional<Instructor> result = instructorRepository.findById(id);
			Instructor tempInstructor = null;
			if(result.isPresent()) {
				tempInstructor = result.get();
			}else {
				throw new GlobalNotFoundException("Instructor details not found with given Id :"+id);
			}
			return tempInstructor.getCourses();
		}
	}
