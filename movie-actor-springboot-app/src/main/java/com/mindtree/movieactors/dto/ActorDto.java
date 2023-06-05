package com.mindtree.movieactors.dto;

public class ActorDto {

	private int actorId;
	private String actorName;
	private String gender;
	private double budget;
	private MovieDto movie;

	public ActorDto() {

	}

	public ActorDto(int actorId, String actorName, String gender, double budget, MovieDto movie) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.gender = gender;
		this.budget = budget;
		this.movie = movie;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public MovieDto getMovie() {
		return movie;
	}

	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}

}
