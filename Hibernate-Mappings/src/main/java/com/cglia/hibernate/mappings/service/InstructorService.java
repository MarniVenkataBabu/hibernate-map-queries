package com.cglia.hibernate.mappings.service;

import java.util.List;

import com.cglia.hibernate.mappings.entity.Course;
import com.cglia.hibernate.mappings.entity.Instructor;
import com.cglia.hibernate.mappings.entity.InstructorDetail;

public interface InstructorService {
	
	
	public List<Instructor> findAll();
	public Instructor findById(int id);
	public void save(Instructor instructor, InstructorDetail instructorDetail);
	public void update(Instructor instructor, int id);
	public void deleteById(int id);
	public void updateInstructorAndDetail(int instructorId, Instructor updatedInstructor,
			InstructorDetail updatedInstructorDetail);
	public List<Course> getAllInstructorCourses(int id);
	
}
