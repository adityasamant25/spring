package com.learning.labs.moviecatalogservice;

import java.util.Arrays;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.labs.moviecatalogservice.models.AuthenticationRequest;
import com.learning.labs.moviecatalogservice.models.AuthenticationResponse;
import com.learning.labs.moviecatalogservice.models.CatalogItem;
import com.learning.labs.moviecatalogservice.models.Movie;
import com.learning.labs.moviecatalogservice.models.MovieRating;
import com.learning.labs.moviecatalogservice.models.UserRating;

@SpringBootTest
class MovieCatalogServiceApplicationTests {

	@Test
	void contextLoads() {

		Movie movieDefault = new Movie();
		Movie movieParameterized = new Movie("100", "Top Gun");

		movieDefault.setMovieId("200");
		movieDefault.setName("X-Men");

		BDDAssertions.assertThat(movieDefault.getMovieId()).isEqualTo("200");
		BDDAssertions.assertThat(movieDefault.getName()).isEqualTo("X-Men");

		BDDAssertions.assertThat(movieParameterized.getMovieId()).isEqualTo("100");
		BDDAssertions.assertThat(movieParameterized.getName()).isEqualTo("Top Gun");

		CatalogItem catalogItemDefault = new CatalogItem();
		CatalogItem catalogItemParameterized = new CatalogItem("Top Gun", "Air Planes", 3);

		catalogItemDefault.setName("X-Men");
		catalogItemDefault.setDesc("Mutants");
		catalogItemDefault.setRating(4);

		BDDAssertions.assertThat(catalogItemDefault.getName()).isEqualTo("X-Men");
		BDDAssertions.assertThat(catalogItemDefault.getDesc()).isEqualTo("Mutants");
		BDDAssertions.assertThat(catalogItemDefault.getRating()).isEqualTo(4);

		BDDAssertions.assertThat(catalogItemParameterized.getName()).isEqualTo("Top Gun");
		BDDAssertions.assertThat(catalogItemParameterized.getDesc()).isEqualTo("Air Planes");
		BDDAssertions.assertThat(catalogItemParameterized.getRating()).isEqualTo(3);

		MovieRating movieRatingDefault = new MovieRating();
		MovieRating movieRatingParameterized = new MovieRating("X-Men", 2);

		movieRatingDefault.setMovieId("Top Gun");
		movieRatingDefault.setRating(1);

		BDDAssertions.assertThat(movieRatingDefault.getMovieId()).isEqualTo("Top Gun");
		BDDAssertions.assertThat(movieRatingDefault.getRating()).isEqualTo(1);

		BDDAssertions.assertThat(movieRatingParameterized.getMovieId()).isEqualTo("X-Men");
		BDDAssertions.assertThat(movieRatingParameterized.getRating()).isEqualTo(2);

		UserRating userRatingDefault = new UserRating();
		UserRating userRatingParameterized = new UserRating(Arrays.asList(new MovieRating("X-Men", 2)));

		userRatingDefault.setUserRatings(Arrays.asList(new MovieRating("Top Gun", 1)));

		BDDAssertions.assertThat(userRatingDefault.getUserRatings()).isNotEmpty();

		BDDAssertions.assertThat(userRatingParameterized.getUserRatings()).isNotEmpty();

		AuthenticationRequest authenticationRequestDefault = new AuthenticationRequest();
		AuthenticationRequest authenticationRequestParameterized = new AuthenticationRequest("foo", "foo");

		authenticationRequestDefault.setUsername("foo");
		authenticationRequestDefault.setPassword("foo");

		BDDAssertions.assertThat(authenticationRequestDefault.getUsername()).isEqualTo("foo");
		BDDAssertions.assertThat(authenticationRequestDefault.getPassword()).isEqualTo("foo");

		BDDAssertions.assertThat(authenticationRequestParameterized.getUsername()).isEqualTo("foo");
		BDDAssertions.assertThat(authenticationRequestParameterized.getPassword()).isEqualTo("foo");

		AuthenticationResponse authenticationResponseParameterized = new AuthenticationResponse("foo");

		BDDAssertions.assertThat(authenticationResponseParameterized.getJwt()).isEqualTo("foo");

	}

}
