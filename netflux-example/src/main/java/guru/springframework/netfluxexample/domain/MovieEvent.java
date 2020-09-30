package guru.springframework.netfluxexample.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieEvent {
	private String movieId;
	private Date date;

}
