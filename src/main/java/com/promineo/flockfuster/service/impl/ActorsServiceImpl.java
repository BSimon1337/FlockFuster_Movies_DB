package com.promineo.flockfuster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.flockfuster.exception.ResourceNotFoundException;
import com.promineo.flockfuster.model.Actors;
import com.promineo.flockfuster.repository.ActorsRepository;
import com.promineo.flockfuster.service.ActorsService;

@Service
public class ActorsServiceImpl implements ActorsService{
	
	private ActorsRepository actorsRepository;
	@Autowired
	public ActorsServiceImpl(ActorsRepository actorsRepository) {
		super();
		this.actorsRepository = actorsRepository;
	}

	@Override
	public Actors saveActors(Actors actors) {
		return actorsRepository.save(actors);
	}

	@Override
	public List<Actors> getAllActors() {
		return actorsRepository.findAll();
	}

	@Override
	public Actors getActorsById(int id) {
		return actorsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", "Id", id));
	}

	@Override
	public Actors updateActors(Actors actors, int id) {
		Actors existingActor = actorsRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Actor", "Id", id));
		existingActor.setFirst_name(actors.getFirst_name());
		existingActor.setLast_name(actors.getLast_name());
		
		actorsRepository.save(existingActor);
		
		
		return existingActor;
	}

	@Override
	public void deleteActor(int id) {
		Actors existingActor = actorsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", "Id", id));
		actorsRepository.deleteById(id);
	}

}
