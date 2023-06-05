package com.mindtree.movieactors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movieactors.dto.ActorDto;
import com.mindtree.movieactors.dto.MovieDto;
import com.mindtree.movieactors.exception.ControllerException;
import com.mindtree.movieactors.exception.service.ActorServiceException;
import com.mindtree.movieactors.service.ActorService;
import com.mindtree.movieactors.service.impl.ActorImpl;

@RestController
@RequestMapping("/Actor")
public class ActorController {
	
	@Autowired
	private ActorService actorService = new ActorImpl();

	// Adding Actor details and assigning it to a Movie
	@PostMapping("/addActor/{movieName}")
	public ResponseEntity<?> addActor(@RequestBody ActorDto actorDto,@PathVariable("movieName") String movieName) throws ControllerException{
		try {
			actorDto = actorService.addActor(actorDto, movieName);
			return ResponseEntity.ok(actorDto);
		}catch (ActorServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	// Getting all Movies acted by a particular Actor
	@GetMapping("/getMoviesByActor/{actorName}")
	public List<MovieDto> getMoviesByActor(@PathVariable("actorName") String actorName) throws ControllerException{
		try {
			return actorService.getMoviesByActor(actorName);
		} catch (ActorServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		
	}
}
