package com.promineo.flockfuster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineo.flockfuster.model.Actors;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Integer>{
	

}