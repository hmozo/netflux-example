package guru.springframework.netfluxexample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.netfluxexample.domain.Movie;
import guru.springframework.netfluxexample.domain.MovieEvent;
import guru.springframework.netfluxexample.service.MovieService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService= movieService;
	}
	
	@GetMapping("/{id}/events")
	Flux<MovieEvent> streamMovieEvent(@PathVariable("id") String movieId){
		return this.movieService.events(movieId);
	}
	
	@GetMapping("/{id}")
	Mono<Movie> getMovieById(String movieId){
		return this.movieService.getMovieById(movieId);
	}
	
	@GetMapping
	Flux<Movie> getAllMovies(){
		return this.movieService.getAllMovied();
	}
	
	
}
