package com.mindtree.movieactors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movieactors.dto.MovieDto;
import com.mindtree.movieactors.exception.ControllerException;
import com.mindtree.movieactors.exception.service.MovieServiceException;
import com.mindtree.movieactors.service.MovieService;
import com.mindtree.movieactors.service.impl.MovieImpl;

@RestController
@RequestMapping("/Movie")
public class MovieController {

	@Autowired
	private MovieService movieService = new MovieImpl();
	
	// Adding Movie Details
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody MovieDto movieDto) throws ControllerException{
		try {
			movieDto = movieService.addMovie(movieDto);
			return ResponseEntity.ok(movieDto);
		}catch (MovieServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	// Getting all Details from Database
	@GetMapping("/getDetails")
	public List<MovieDto> getDetails(){
		return movieService.getDetails();
	}
	
}
