package com.cglia.hibernate.mappings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cglia.hibernate.mappings.entity.Review;
import com.cglia.hibernate.mappings.exceptionhandling.GlobalNotFoundException;
import com.cglia.hibernate.mappings.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	    private ReviewRepository reviewRepository;

	    public ReviewServiceImpl(ReviewRepository reviewRepository) {
	        this.reviewRepository = reviewRepository;
	    }

	    @Override
	    public List<Review> findAll() {
	        return reviewRepository.findAll();
	    }

	    @Override
	    public Review findById(int id) {
	        Optional<Review> result = reviewRepository.findById(id);
	        if (result.isPresent()) {
	            return result.get();
	        } else {
	            throw new GlobalNotFoundException("Review not found with id: " + id);
	        }
	    }

	    @Override
	    public void save(Review review) {
	        reviewRepository.save(review);
	    }

	    @Override
	    public void update(Review review, int id) {
	        Optional<Review> result = reviewRepository.findById(id);
	        if (result.isPresent()) {
	            Review existingReview = result.get();
	            existingReview.setComment(review.getComment());
	            reviewRepository.save(existingReview);
	        } else {
	            throw new GlobalNotFoundException("Review not found with id: " + id);
	        }
	    }

	    @Override
	    public void deleteById(int id) {
	        reviewRepository.deleteById(id);
	    }
	}

