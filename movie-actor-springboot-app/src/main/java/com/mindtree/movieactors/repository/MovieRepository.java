package com.mindtree.movieactors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.movieactors.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query("Select m from Movie m where m.movieName=?1")
	Movie findByMovieName(String movieName);

}
