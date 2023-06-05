package com.mindtree.movieactors.service;

import java.util.List;

import com.mindtree.movieactors.dto.MovieDto;
import com.mindtree.movieactors.exception.service.MovieServiceException;

public interface MovieService {

	public MovieDto addMovie(MovieDto movieDto) throws MovieServiceException;

	public List<MovieDto> getDetails();

}
