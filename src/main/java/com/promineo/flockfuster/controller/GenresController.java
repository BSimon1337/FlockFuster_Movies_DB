package com.promineo.flockfuster.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.flockfuster.model.Actors;
import com.promineo.flockfuster.model.Genres;
import com.promineo.flockfuster.service.GenresService;


@RestController
@RequestMapping("FlockFuster/genres")
public class GenresController {
	
	private GenresService genresService;
	
	public GenresController(GenresService genresService) {
		super();
		this.genresService = genresService;
	}
	
	@PostMapping
	public ResponseEntity<Genres> saveActors(@RequestBody Genres genres){
		return new ResponseEntity<Genres>(genresService.saveGenres(genres), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Genres> getAllGenres(){
		return genresService.getAllGenres();
	}
	@GetMapping("{genre_id}")
	public ResponseEntity<Genres> getGenresById(@PathVariable("genre_id") int genre_id){
		return new ResponseEntity<Genres>(genresService.getGenresById(genre_id), HttpStatus.OK);
	}
	
	@PutMapping("{genre_id}")
	public ResponseEntity<Genres> updateGenres(@PathVariable("genre_id") int genre_id, @RequestBody Genres genres){
		return new ResponseEntity<Genres>(genresService.updateActors(genres, genre_id), HttpStatus.OK);
	}
	
	@DeleteMapping("{genre_id}")
	public ResponseEntity<String> delereGenre(@PathVariable("genre_id") int genreId){
		genresService.deleteGenre(genreId);
		
		return new ResponseEntity<String>("Genre got un-genred!", HttpStatus.OK);
	}

}
