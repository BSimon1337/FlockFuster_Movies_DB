package com.promineo.flockfuster.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.promineo.flockfuster.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query("SELECT m FROM Movie m WHERE m.director_id = ?1")
	Set<Movie> getAllByDirectorId(int id);
	
	@Query("SELECT m FROM Movie m WHERE m.actors_id = ?1")
	Set<Movie> getAllByActorId(int id);

}
