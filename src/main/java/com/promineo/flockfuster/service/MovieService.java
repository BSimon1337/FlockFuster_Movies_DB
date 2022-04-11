package com.promineo.flockfuster.service;

import java.util.List;

import com.promineo.flockfuster.model.Movie;

public interface MovieService {

	Movie saveMovie(Movie movie);

	List<Movie> getAllMovies();

	Movie getMovieById(int id);
	
	Movie updateMovie(Movie movie, int Id);

	
}
