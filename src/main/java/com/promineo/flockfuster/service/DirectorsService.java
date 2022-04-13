package com.promineo.flockfuster.service;

import java.util.List;

import com.promineo.flockfuster.model.Directors;




public interface DirectorsService {
	
	Directors saveDirectors(Directors director);
	
	List<Directors> getAllDirectors();
	
	Directors getDirectorsById(int id);
	
	Directors updateDirectors(Directors directors, int Id);
	
	void deleteDirector(int id);

}
