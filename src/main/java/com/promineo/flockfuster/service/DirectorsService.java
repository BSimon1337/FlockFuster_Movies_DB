package com.promineo.flockfuster.service;

import java.util.List;
import com.promineo.flockfuster.model.Directors;
import com.promineo.flockfuster.model.Movie;




public interface DirectorsService {
	
	Directors saveDirectors(Directors director);
	
	List<Directors> getAllDirectors();
	
	Directors getDirectorsById(int id);
	
	Directors updateDirectors(Directors directors, int Id);
	
	void deleteDirector(int id);
	
	//List<Movie> getAllDirectorMovies(int id);
	
	//List<Movie> updateDirectorMovies(Directors director, int movieId, int directorId);

}
