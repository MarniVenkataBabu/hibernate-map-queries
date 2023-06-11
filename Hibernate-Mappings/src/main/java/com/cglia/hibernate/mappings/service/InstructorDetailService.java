package com.cglia.hibernate.mappings.service;

import java.util.List;

import com.cglia.hibernate.mappings.entity.InstructorDetail;

public interface InstructorDetailService {
  
	public List<InstructorDetail> findAll();
	public InstructorDetail findById(int id);
	public void save(InstructorDetail instructorDetail);
	public void update(InstructorDetail instructorDetail, int id);
	public void deleteById(int id);

}
