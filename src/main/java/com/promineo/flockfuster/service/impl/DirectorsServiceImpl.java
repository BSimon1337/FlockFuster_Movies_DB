package com.promineo.flockfuster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.flockfuster.exception.ResourceNotFoundException;
import com.promineo.flockfuster.model.Directors;
import com.promineo.flockfuster.repository.DirectorsRepository;
import com.promineo.flockfuster.service.DirectorsService;

@Service
public class DirectorsServiceImpl implements DirectorsService {
	
	private DirectorsRepository directorsRepository;
	
	@Autowired
	public DirectorsServiceImpl(DirectorsRepository directorsRepository) {
		super();
		this.directorsRepository = directorsRepository;
	}

	@Override
	public Directors saveDirectors(Directors directors) {
		return directorsRepository.save(directors);
	}
	@Override
	public List<Directors> getAllDirectors(){
		return directorsRepository.findAll();
	}

	@Override
	public Directors getDirectorsById(int id) {
		return directorsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Director", "Id", id));
		
	}

	@Override
	public Directors updateDirectors(Directors directors, int id) {
		Directors existingDirector = directorsRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Director", "Id", id));
		existingDirector.setFirst_name(directors.getFirst_name());
		existingDirector.setLast_name(directors.getLast_name());
		
		directorsRepository.save(existingDirector);
		
		
		return existingDirector;
	}

	@Override
	public void deleteDirector(int id) {
		Directors existingDirector = directorsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Director", "Id", id));
		directorsRepository.deleteById(id);
	}

}
