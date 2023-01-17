package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping()
	public ResponseEntity<Page<MovieDTO>> findPageMovieByGenre(
			@RequestParam(value = "genreId", defaultValue = "0")Long genreId,
			Pageable pageable
			){
		
		Page<MovieDTO> page = service.findPageMovieByGenre(pageable, genreId);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{idMovie}/reviews")
	public ResponseEntity<List<ReviewDTO>> findReviewsMovieId(@PathVariable Long idMovie){
		
		List<ReviewDTO> list = service.findReviewsMovieId(idMovie);
		return ResponseEntity.ok().body(list);
	}

}
