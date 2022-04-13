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
import com.promineo.flockfuster.service.ActorsService;

@RestController
@RequestMapping("FlockFuster/actors")
public class ActorsController {
	
	private ActorsService actorsService;

	public ActorsController(ActorsService actorsService) {
		super();
		this.actorsService = actorsService;
	}
	@PostMapping
	public ResponseEntity<Actors> saveActors(@RequestBody Actors actors){
		return new ResponseEntity<Actors>(actorsService.saveActors(actors), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Actors> getAllActors(){
		return actorsService.getAllActors();
	}
	@GetMapping("{actor_id}")
	public ResponseEntity<Actors> getActorsById(@PathVariable("actor_id") int actor_id){
		return new ResponseEntity<Actors>(actorsService.getActorsById(actor_id), HttpStatus.OK);
	}
	
	@PutMapping("{actor_id}")
	public ResponseEntity<Actors> updateActors(@PathVariable("actor_id") int actor_id, @RequestBody Actors actors){
		return new ResponseEntity<Actors>(actorsService.updateActors(actors, actor_id), HttpStatus.OK);
	}
	
	@DeleteMapping("{actor_id}")
	public ResponseEntity<String> deleteActor(@PathVariable("actor_id") int actorId){
		actorsService.deleteActor(actorId);
		
		return new ResponseEntity<String>("Actor was recast!", HttpStatus.OK);
	}

}
