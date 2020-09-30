package guru.springframework.netfluxexample.domain;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	
	private String id;
	@NonNull
	private String title;
}
