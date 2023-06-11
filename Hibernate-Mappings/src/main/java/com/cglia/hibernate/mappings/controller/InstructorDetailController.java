package com.cglia.hibernate.mappings.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.mappings.entity.InstructorDetail;
import com.cglia.hibernate.mappings.service.InstructorDetailService;

@RestController
@RequestMapping("/api/instructordetails")
public class InstructorDetailController {
       
	private InstructorDetailService instructorDetailService;
	
	public InstructorDetailController(InstructorDetailService instructorDetailService) {
		this.instructorDetailService = instructorDetailService;
	}
	
	@GetMapping
	public List<InstructorDetail> getAllinstructorDetails(){
		return instructorDetailService.findAll();
	}
	
	@GetMapping("/{id}")
	public InstructorDetail getSingleInstructorDetail(@PathVariable int id) {
		return instructorDetailService.findById(id);
	}
	
	
}
