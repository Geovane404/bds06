package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

		@Query ("SELECT DISTINCT mov FROM Movie mov " +
	            "INNER JOIN mov.genre gen " +
	            "WHERE (:genre IS NULL OR :genre IN gen ) ORDER BY mov.title " )
	    Page<Movie> findPageMovieByGenre(Genre genre, Pageable pageable);
		
}
