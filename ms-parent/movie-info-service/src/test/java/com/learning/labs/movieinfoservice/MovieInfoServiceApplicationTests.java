package com.learning.labs.movieinfoservice;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.labs.movieinfoservice.models.Movie;
import com.learning.labs.movieinfoservice.models.MovieSummary;

@SpringBootTest
class MovieInfoServiceApplicationTests {

	@Test
	void contextLoads() {
		Movie movieDefault = new Movie();
		Movie movieParameterized = new Movie("200", "X-Men", "Mutants");

		movieDefault.setMovieId("100");
		movieDefault.setName("Top Gun");
		movieDefault.setDescription("Air planes");

		BDDAssertions.assertThat(movieDefault.getMovieId()).isEqualTo("100");
		BDDAssertions.assertThat(movieDefault.getName()).isEqualTo("Top Gun");
		BDDAssertions.assertThat(movieDefault.getDescription()).isEqualTo("Air planes");

		BDDAssertions.assertThat(movieParameterized.getMovieId()).isEqualTo("200");
		BDDAssertions.assertThat(movieParameterized.getName()).isEqualTo("X-Men");
		BDDAssertions.assertThat(movieParameterized.getDescription()).isEqualTo("Mutants");

		MovieSummary movieSummaryDefault = new MovieSummary();
		MovieSummary movieSummaryParameterized = new MovieSummary("X-Men","Mutants");

		movieSummaryDefault.setOriginal_title("Top Gun");
		movieSummaryDefault.setOverview("Air planes");

		BDDAssertions.assertThat(movieSummaryDefault.getOriginal_title()).isEqualTo("Top Gun");
		BDDAssertions.assertThat(movieSummaryDefault.getOverview()).isEqualTo("Air planes");

		BDDAssertions.assertThat(movieSummaryParameterized.getOriginal_title()).isEqualTo("X-Men");
		BDDAssertions.assertThat(movieSummaryParameterized.getOverview()).isEqualTo("Mutants");
	}

}
