package com.promineo.flockfuster.service;

import java.util.List;

import com.promineo.flockfuster.model.Actors;

public interface ActorsService {

	Actors saveActors(Actors actors);

	List<Actors> getAllActors();

	Actors getActorsById(int actor_id);

	Actors updateActors(Actors actors, int actor_id);

	void deleteActor(int actorId);

}
