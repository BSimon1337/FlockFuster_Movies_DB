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

import com.promineo.flockfuster.model.Directors;
import com.promineo.flockfuster.service.DirectorsService;


@RestController
@RequestMapping("FlockFuster/directors")
public class DirectorsController {
	
	private DirectorsService directorsService;

	public DirectorsController(DirectorsService directorsService) {
		super();
		this.directorsService = directorsService;
	}
	@PostMapping
	public ResponseEntity<Directors> saveDirectors(@RequestBody Directors directors){
		return new ResponseEntity<Directors>(directorsService.saveDirectors(directors), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Directors> getAllDirectors(){
		return directorsService.getAllDirectors();
	}
	@GetMapping("{director_id}")
	public ResponseEntity<Directors> getDirectorsById(@PathVariable("director_id") int director_id){
		return new ResponseEntity<Directors>(directorsService.getDirectorsById(director_id), HttpStatus.OK);
	}
	
	@PutMapping("{director_id}")
	public ResponseEntity<Directors> updateDirector(@PathVariable("director_id") int director_id, @RequestBody Directors directors){
		return new ResponseEntity<Directors>(directorsService.updateDirectors(directors, director_id), HttpStatus.OK);
	}
	
	@DeleteMapping("{director_id}")
	public ResponseEntity<String> deleteDirector(@PathVariable("director_id") int directorId){
		directorsService.deleteDirector(directorId);
		
		return new ResponseEntity<String>("Director fired!", HttpStatus.OK);
	}

}
