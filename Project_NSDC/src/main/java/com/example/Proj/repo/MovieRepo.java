package com.example.Proj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Proj.Entity.Movie;

public interface MovieRepo  extends JpaRepository<Movie, Integer> {

	List<Movie> getMovieByGenres(String genres);

}
