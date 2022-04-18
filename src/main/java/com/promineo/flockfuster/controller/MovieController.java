package com.promineo.flockfuster.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.flockfuster.model.Actors;
import com.promineo.flockfuster.model.Movie;
import com.promineo.flockfuster.service.MovieService;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("FlockFuster/movies")
public class MovieController {
	
	
	
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	//create a movie
	@PostMapping()
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
		return new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	@GetMapping("{movie_id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("movie_id") int movie_id){
		return new ResponseEntity<Movie>(movieService.getMovieById(movie_id), HttpStatus.OK);
	}
	
	@PutMapping("{movie_id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable("movie_id") int movie_Id, @RequestBody Movie movie){
		return new ResponseEntity<Movie>(movieService.updateMovie(movie, movie_Id), HttpStatus.OK);
	}
	
	@DeleteMapping("{movie_id}")
	public ResponseEntity<String> deleteMovie(@PathVariable("movie_id") int movieId){
		movieService.deleteMovie(movieId);
		
		return new ResponseEntity<String>("Movie gone!", HttpStatus.OK);
	}
	@GetMapping("movie/{movie_id}/actors")
	public List<Actors> getAllCastMembers(@PathVariable("movie_id") int movieId){
		return movieService.getAllCastMembers(movieId);
	}
	
	@PutMapping("movie/{movie_id}/actors/{actors_id}")
	public List<Actors> updateCastMembers(@PathVariable("movie_id") int movieId, int actorsId, @RequestBody Movie movie){
		Set<Actors> actorsSet = movieService.updateCastMembers(movie, movieId, actorsId);
		List<Actors> actorsList = new ArrayList<>(actorsSet);
		return actorsList;
	}
	
	
	
}
