package com.mindtree.movieactors.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movieactors.dto.MovieDto;
import com.mindtree.movieactors.entity.Movie;
import com.mindtree.movieactors.exception.service.MovieExistException;
import com.mindtree.movieactors.exception.service.MovieServiceException;
import com.mindtree.movieactors.repository.MovieRepository;
import com.mindtree.movieactors.service.MovieService;

@Service
public class MovieImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	static ModelMapper mapper = new ModelMapper();

	// Adding Movie Details to database
	@Override
	public MovieDto addMovie(MovieDto movieDto) throws MovieServiceException {
		Movie movie = movieRepository.findByMovieName(movieDto.getMovieName());
		try {
			if (movie == null) {
				Movie movie1 = mapper.map(movieDto, Movie.class);
				Movie movieRep = movieRepository.save(movie1);
				movieDto = mapper.map(movieRep, MovieDto.class);
				return movieDto;
			} else {
				throw new MovieExistException("Movie Already exist");
			}
		} catch (MovieExistException e) {
			throw new MovieServiceException(e.getMessage());
		}
	}

	// Getting all Details from Database
	@Override
	public List<MovieDto> getDetails() {
		List<Movie> movies = movieRepository.findAll();
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		Collections.sort(movies, new Comparator<Movie>() {

			@Override
			public int compare(Movie m1, Movie m2) {
				return m1.getMovieName().compareToIgnoreCase(m2.getMovieName());
			}
		});
		for(Movie m:movies) {
			movieDtos.add(mapper.map(m, MovieDto.class));
		}
		return movieDtos;
	}
}
