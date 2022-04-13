package com.promineo.flockfuster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.flockfuster.exception.ResourceNotFoundException;
import com.promineo.flockfuster.model.Actors;
import com.promineo.flockfuster.model.Genres;
import com.promineo.flockfuster.repository.GenresRepository;
import com.promineo.flockfuster.service.GenresService;

@Service
public class GenresServiceImpl implements GenresService{
	
	@Autowired
	private GenresRepository genresRepository;

	public GenresServiceImpl(GenresRepository genresRepository) {
		super();
		this.genresRepository = genresRepository;
	}

	@Override
	public Genres saveGenres(Genres genres) {
		return genresRepository.save(genres);
	}

	@Override
	public List<Genres> getAllGenres() {
		return genresRepository.findAll();
	}

	@Override
	public Genres getGenresById(int id) {
		return genresRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "Id", id));
	}

	@Override
	public Genres updateActors(Genres genres, int id) {
		Genres existingGenre = genresRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Genre", "Id", id));
		existingGenre.setGenre(genres.getGenre());
		
		genresRepository.save(existingGenre);
		
		
		return existingGenre;
	}

	@Override
	public void deleteGenre(int id) {
		Genres existingGenre = genresRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "Id", id));
		genresRepository.deleteById(id);
	}

}
