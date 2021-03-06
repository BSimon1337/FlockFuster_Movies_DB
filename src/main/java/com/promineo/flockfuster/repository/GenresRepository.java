package com.promineo.flockfuster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineo.flockfuster.model.Genres;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer>{

}
