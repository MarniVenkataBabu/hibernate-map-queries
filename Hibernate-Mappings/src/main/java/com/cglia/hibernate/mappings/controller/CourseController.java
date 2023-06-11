package com.cglia.hibernate.mappings.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.mappings.entity.Course;
import com.cglia.hibernate.mappings.entity.Review;
import com.cglia.hibernate.mappings.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	    private CourseService courseService;

	    public CourseController(CourseService courseService) {
	        this.courseService = courseService;
	    }

	    @GetMapping
	    public List<Course> getAllCourses() {
	        return courseService.findAll();
	    }

	    @GetMapping("/{id}")
	    public Course getCourseById(@PathVariable int id) {
	        return courseService.findById(id);
	    }

	    @PostMapping
	    public void addCourse(@RequestBody Course course) {
	        courseService.save(course);
	    }

	    @PutMapping("/{id}")
	    public void updateCourse(@RequestBody Course course, @PathVariable int id) {
	        courseService.update(course, id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCourse(@PathVariable int id) {
	        courseService.deleteById(id);
	    }
	    
	    @GetMapping("/reviews/{id}")
	    public List<Review> getAllCourseReviews(@PathVariable int id){
	    	return courseService.getAllCourseReviews(id);
	    }
	}

