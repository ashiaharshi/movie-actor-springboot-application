package com.mindtree.movieactors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.movieactors.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{

}
