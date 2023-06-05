package com.mindtree.movieactors.service;

import java.util.List;

import com.mindtree.movieactors.dto.ActorDto;
import com.mindtree.movieactors.dto.MovieDto;
import com.mindtree.movieactors.exception.service.ActorServiceException;

public interface ActorService {

	ActorDto addActor(ActorDto actorDto, String movieName) throws ActorServiceException;

	List<MovieDto> getMoviesByActor(String actorName) throws ActorServiceException;

}
