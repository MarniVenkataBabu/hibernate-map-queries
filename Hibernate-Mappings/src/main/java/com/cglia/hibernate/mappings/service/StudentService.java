package com.cglia.hibernate.mappings.service;

import java.util.List;

import com.cglia.hibernate.mappings.entity.Course;
import com.cglia.hibernate.mappings.entity.Student;


public interface StudentService {

	public List<Student> findAll();
	public Student findById(int id);
	public void save(Student student);
	public void update(Student student, int id);
	public void deleteById(int id);
	public List<Course> getStudentCourses(int id);

}
