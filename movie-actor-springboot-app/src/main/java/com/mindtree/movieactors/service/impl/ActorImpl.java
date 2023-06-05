package com.mindtree.movieactors.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.movieactors.dto.ActorDto;
import com.mindtree.movieactors.dto.MovieDto;
import com.mindtree.movieactors.entity.Actor;
import com.mindtree.movieactors.entity.Movie;
import com.mindtree.movieactors.exception.service.ActorServiceException;
import com.mindtree.movieactors.exception.service.MovieExistException;
import com.mindtree.movieactors.exception.service.NoSuchActorException;
import com.mindtree.movieactors.repository.ActorRepository;
import com.mindtree.movieactors.repository.MovieRepository;
import com.mindtree.movieactors.service.ActorService;

@Service
public class ActorImpl implements ActorService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ActorRepository actorRepository;

	static ModelMapper mapper = new ModelMapper();

	// Adding Actor details and assigning it to a Movie
	@Override
	public ActorDto addActor(ActorDto actorDto, String movieName) throws ActorServiceException {
		Movie movie = movieRepository.findByMovieName(movieName);
		List<Actor> actors = new ArrayList<Actor>();
		try {
			if (movie != null) {
				Actor actor = mapper.map(actorDto, Actor.class);
				actor.setMovie(movie);
				Actor actorRep = actorRepository.save(actor);

				actors.add(actor);
				movie.setActors(actors);
				movie = movieRepository.save(movie);
				actorDto = mapper.map(actorRep, ActorDto.class);
			} else
				throw new MovieExistException("No such movie exist");
		} catch (DataAccessException | MovieExistException e) {
			throw new ActorServiceException(e.getMessage());
		}
		return actorDto;
	}

	// Getting all Movies acted by a particular Actor Using Filters
	@Override
	public List<MovieDto> getMoviesByActor(String actorName) throws ActorServiceException {
		List<Actor> actors = actorRepository.findAll();
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		actors = actors.stream().filter(a -> a.getActorName().equalsIgnoreCase(actorName)).collect(Collectors.toList());
		try {
		if(actors.size()!=0) {
		for (Actor a : actors) 
			movieDtos.add(mapper.map(a.getMovie(), MovieDto.class));

		return movieDtos;
		}
		else
			throw new NoSuchActorException("No such Actor exist");
		}catch (NoSuchActorException e) {
			throw new ActorServiceException(e.getMessage());
		}
	}

}
