package com.promineo.flockfuster.service;

import java.util.List;

import com.promineo.flockfuster.model.Genres;

public interface GenresService {

	Genres saveGenres(Genres genres);

	List<Genres> getAllGenres();

	Genres getGenresById(int genre_id);

	Genres updateActors(Genres genres, int genre_id);

	void deleteGenre(int genreId);

}
