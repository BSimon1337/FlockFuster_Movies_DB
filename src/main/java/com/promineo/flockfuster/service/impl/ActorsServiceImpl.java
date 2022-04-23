package com.promineo.flockfuster.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.promineo.flockfuster.exception.ResourceNotFoundException;
import com.promineo.flockfuster.model.Actors;
import com.promineo.flockfuster.model.Movie;
import com.promineo.flockfuster.repository.ActorsRepository;
import com.promineo.flockfuster.repository.MovieRepository;
import com.promineo.flockfuster.service.ActorsService;

@Service
public class ActorsServiceImpl implements ActorsService{
	
	
	private ActorsRepository actorsRepository;
	private MovieRepository movieRepository;
	
	@Autowired
	public ActorsServiceImpl(ActorsRepository actorsRepository, MovieRepository movieRepository) {
		super();
		this.actorsRepository = actorsRepository;
		this.movieRepository = movieRepository;
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

	@Override
	public List<Movie> getAllActorMovies(int id) {
		Set<Movie> movieSet = movieRepository.getAllByActorId(id);
		List<Movie> movieList = new ArrayList<>(movieSet);
		return movieList;
	}

	

}
