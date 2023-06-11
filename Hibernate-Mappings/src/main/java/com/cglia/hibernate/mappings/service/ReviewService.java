package com.cglia.hibernate.mappings.service;

import java.util.List;

import com.cglia.hibernate.mappings.entity.Review;


public interface ReviewService {
    
	public List<Review> findAll();
	public Review findById(int id);
	public void save(Review review);
	public void update(Review review, int id);
	public void deleteById(int id);

}
