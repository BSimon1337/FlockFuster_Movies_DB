package com.promineo.flockfuster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineo.flockfuster.model.Directors;
import com.promineo.flockfuster.model.Movie;
@Repository
public interface DirectorsRepository extends JpaRepository<Directors, Integer>{

}
