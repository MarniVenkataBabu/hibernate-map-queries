package com.cglia.hibernate.mappings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.mappings.entity.Course;
import com.cglia.hibernate.mappings.entity.Instructor;
import com.cglia.hibernate.mappings.entity.InstructorDetail;
import com.cglia.hibernate.mappings.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

	    private InstructorService instructorService;

	    @Autowired
	    public InstructorController(InstructorService instructorService) {
	        this.instructorService = instructorService;
	    }

	    @GetMapping
	    public List<Instructor> getAllInstructors() {
	        return instructorService.findAll();
	    }

	    @GetMapping("/{id}")
	    public Instructor getInstructorById(@PathVariable int id) {
	        return instructorService.findById(id);
	    }

	    @PostMapping
	    public void createInstructor(@RequestBody Instructor instructorDTO, InstructorDetail instructorDetailDTO) {
	        Instructor instructor = new Instructor(instructorDTO.getFirstName(), instructorDTO.getLastName(), instructorDTO.getEmail());
	        InstructorDetail instructorDetail = new InstructorDetail(instructorDetailDTO.getYoutubeChannel(), instructorDetailDTO.getHobby());
	        instructorService.save(instructor, instructorDetail);
	    }

	    @PutMapping("/{id}")
	    public void updateInstructor(@PathVariable int id, @RequestBody Instructor instructorDTO) {
	        Instructor instructor = new Instructor(instructorDTO.getFirstName(), instructorDTO.getLastName(), instructorDTO.getEmail());
	        instructorService.update(instructor, id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteInstructor(@PathVariable int id) {
	        instructorService.deleteById(id);
	    }

	    @PutMapping("/{id}/update-instructor-detail")
	    public void updateInstructorAndDetail(@PathVariable int id, @RequestBody Instructor instructorDTO, InstructorDetail instructorDetailDTO) {
	        Instructor instructor = new Instructor(instructorDTO.getFirstName(), instructorDTO.getLastName(), instructorDTO.getEmail());
	        InstructorDetail instructorDetail = new InstructorDetail(instructorDetailDTO.getYoutubeChannel(), instructorDetailDTO.getHobby());
	        instructorService.updateInstructorAndDetail(id, instructor, instructorDetail);
	    }
	    
	    @GetMapping("/courses/{id}")
	    public List<Course> getAllInstructorCourses(@PathVariable int id){
	    	return instructorService.getAllInstructorCourses(id);
	    }
	}
