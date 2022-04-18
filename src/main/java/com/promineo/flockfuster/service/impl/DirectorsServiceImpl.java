package com.promineo.flockfuster.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.flockfuster.exception.ResourceNotFoundException;
import com.promineo.flockfuster.model.Actors;
import com.promineo.flockfuster.model.Directors;
import com.promineo.flockfuster.model.Movie;
import com.promineo.flockfuster.repository.DirectorsRepository;
import com.promineo.flockfuster.repository.MovieRepository;
import com.promineo.flockfuster.service.DirectorsService;

@Service
public class DirectorsServiceImpl implements DirectorsService {
	
	private DirectorsRepository directorsRepository;
	private MovieRepository movieRepository;
	
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

	//@Override
	//public List<Movie> getAllDirectorMovies(int id) {
		//Directors currentDirector = directorsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Director", "id", id));
		//return currentDirector.getMovies();
	//}

	//@Override
	//public List<Movie> updateDirectorMovies(Directors director, int movieId, int directorId) {
		//Directors existingDirector = directorsRepository.findById(directorId).orElseThrow( () -> new ResourceNotFoundException("Director", "id", directorId));
		//Movie existingMovie = movieRepository.findById(movieId).orElseThrow( () -> new ResourceNotFoundException("Movie", "id", movieId));
		
		//List<Movie> directorMovies = existingDirector.getMovies();
		
		//directorMovies.add(existingMovie);
		//existingDirector.setMovies(directorMovies);
		
		//directorsRepository.save(existingDirector);
		
		//return existingDirector.getMovies();
	//}

}
