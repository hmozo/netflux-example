package guru.springframework.netfluxexample.bootstrap;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.netfluxexample.domain.Movie;
import guru.springframework.netfluxexample.repositories.MovieRepository;
import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner{

	private final MovieRepository movieRepository;
	
	public BootstrapCLR(MovieRepository movieRepository) {
		this.movieRepository= movieRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		movieRepository.deleteAll()
			.thenMany(
				Flux.just("Silence of the lambdas", "AEon Flux", "Enter the Mono<void>", "The fluxxinator",
					"Back to the future", "Meet the Fluxes", "Lord of the Fluxes").log()
				.map((String title) -> new Movie(UUID.randomUUID().toString(),title))
				.flatMap(movieRepository::save))
			.subscribe(null, null, ()->{
				movieRepository.findAll().subscribe(System.out::println);
			});
			
		
	}

}
