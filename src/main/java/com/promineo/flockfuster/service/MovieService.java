package com.promineo.flockfuster.service;

import java.util.List;
import java.util.Set;

import com.promineo.flockfuster.model.Actors;
import com.promineo.flockfuster.model.Movie;

public interface MovieService {
	
	
	//Create
	Movie saveMovie(Movie movie);
	//Read all
	List<Movie> getAllMovies();
	//Read by id
	Movie getMovieById(int id);
	//Update
	Movie updateMovie(Movie movie, int Id);
	//Delete
	void deleteMovie(int id);
	
	List<Actors> getAllCastMembers(int id);
	
	Set<Actors> updateCastMembers(int actorId, int movieId);

	
}
