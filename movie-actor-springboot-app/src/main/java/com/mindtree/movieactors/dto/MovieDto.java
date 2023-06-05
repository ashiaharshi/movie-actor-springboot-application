package com.mindtree.movieactors.dto;

import java.util.List;

import com.mindtree.movieactors.entity.Actor;

public class MovieDto {
	
	private int movieId;
	private String movieName;
	private double totalBudget;
	private List<Actor> actors;
	
	public MovieDto() {
	
	}
	public MovieDto(int movieId, String movieName, double totalBudget, List<Actor> actors) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.totalBudget = totalBudget;
		this.actors = actors;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public double getTotalBudget() {
		return totalBudget;
	}
	public void setTotalBudget(double totalBudget) {
		this.totalBudget = totalBudget;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
}
