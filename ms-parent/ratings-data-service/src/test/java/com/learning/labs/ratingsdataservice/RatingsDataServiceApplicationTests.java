package com.learning.labs.ratingsdataservice;

import java.util.Arrays;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.labs.ratingsdataservice.models.MovieRating;
import com.learning.labs.ratingsdataservice.models.UserRating;

@SpringBootTest
class RatingsDataServiceApplicationTests {

	@Test
	void contextLoads() {
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
	}

}
