package guru.springframework.netfluxexample.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document
@Data
@NoArgsConstructor
public class Movie {
	
	private String id;
	@NonNull
	private String title;
}
