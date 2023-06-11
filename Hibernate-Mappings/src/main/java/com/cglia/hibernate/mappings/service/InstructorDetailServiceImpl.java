package com.cglia.hibernate.mappings.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.cglia.hibernate.mappings.entity.Instructor;
import com.cglia.hibernate.mappings.entity.InstructorDetail;
import com.cglia.hibernate.mappings.exceptionhandling.GlobalNotFoundException;
import com.cglia.hibernate.mappings.repository.InstructorDetailRepository;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService{
    
	private InstructorDetailRepository instructorDetailRepository;
	
	public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
		this.instructorDetailRepository = instructorDetailRepository;
	}
	@Override
	public List<InstructorDetail> findAll() {
		return instructorDetailRepository.findAll();
	}

	@Override
	public InstructorDetail findById(int id) {
		Optional<InstructorDetail> result = instructorDetailRepository.findById(id);
		InstructorDetail instructorDetail = null;
		if(result.isPresent()) {
			instructorDetail = result.get();
		}else {
			throw new GlobalNotFoundException("InstructorDetail Id is not found with : "+id);
		}
		return instructorDetail;
	}

	@Override
	public void save(InstructorDetail instructorDetail) {
		instructorDetail.setId(0);
		instructorDetailRepository.save(instructorDetail);
	}

	@Override
	public void update(InstructorDetail instructorDetail, int id) {
		Optional<InstructorDetail> result = instructorDetailRepository.findById(id);
		InstructorDetail oldInstructorDetail = null;
		if(result.isPresent()) {
			oldInstructorDetail = result.get();
			oldInstructorDetail.setYoutubeChannel(instructorDetail.getYoutubeChannel());
			oldInstructorDetail.setHobby(instructorDetail.getHobby());
			instructorDetail.setId(id);
			instructorDetailRepository.save(instructorDetail);
		}else {
			throw new GlobalNotFoundException("Instructor details not found with id :"+id);
		}
		
	}

	@Override
	public void deleteById(int id) {
		Optional<InstructorDetail> result = instructorDetailRepository.findById(id);
		InstructorDetail instructorDetail = null;
		if(result.isEmpty()) {
			throw new GlobalNotFoundException("Instructor Id not found with the given id : "+id);
		}
		instructorDetailRepository.deleteById(id);
	}

}
