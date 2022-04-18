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
import com.promineo.flockfuster.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	
	private MovieRepository movieRepository;
	private ActorsRepository actorsRepository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository, ActorsRepository actorsRepository) {
		super();
		this.movieRepository = movieRepository;
		this.actorsRepository = actorsRepository;
	}
	
	//CREATE

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	//Read
	@Override
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(int id) {
		return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", id));
	}

	
	@Override
	public Movie updateMovie(Movie movie, int id) {
		Movie existingMovie = movieRepository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Movie", "Id", id));
		existingMovie.setActors_id(movie.getActors_id());
		existingMovie.setDirector_id(movie.getDirector_id());
		existingMovie.setGenre_id(movie.getGenre_id());
		existingMovie.setTitle(movie.getTitle());
		existingMovie.setYear_released(movie.getYear_released());
		existingMovie.setStudio(movie.getStudio());
		
		movieRepository.save(existingMovie);
		
		return existingMovie;
	}
	
	@Override
	public void deleteMovie(int id) {
		Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", id));
		movieRepository.deleteById(id);
	}


	@Override
	public List<Actors> getAllCastMembers(int id) {
		Movie currentMovie = movieRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Movie", "id", id));
		Set<Actors> castMembersSet = currentMovie.getCastMembers();
		List<Actors> castMembersList = new ArrayList<>(castMembersSet);
		return castMembersList;
	}

	@Override
	public Set<Actors> updateCastMembers(Movie movie, int actorId, int movieId) {
		Movie existingMovie = movieRepository.findById(movieId).orElseThrow( () -> new ResourceNotFoundException("Movie", "id", movieId));
		Actors existingActor = actorsRepository.findById(actorId).orElseThrow( () -> new ResourceNotFoundException("Actor", "id", actorId));
		
		Set<Actors> castMembers = existingMovie.getCastMembers();
		
		castMembers.add(existingActor);
		existingMovie.setCastMembers(castMembers);
		
		movieRepository.save(existingMovie);
		
		return existingMovie.getCastMembers();
	}

	

}
