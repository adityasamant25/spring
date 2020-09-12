package com.learning.labs.moviecatalogservice;

import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.learning.labs.moviecatalogservice.models.CatalogItem;
import com.learning.labs.moviecatalogservice.resources.MovieCatalogResource;

@SpringBootTest
@AutoConfigureWireMock
@AutoConfigureStubRunner(ids = { "com.learning.labs:ratings-data-service:0.0.1-SNAPSHOT:stubs",
		"com.learning.labs:movie-info-service:0.0.1-SNAPSHOT:stubs" }, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class MovieCatalogContractTests {

	static {
		System.setProperty("eureka.client.enabled", "false");
		System.setProperty("spring.cloud.config.failFast", "false");
	}

	@Autowired
	MovieCatalogResource movieCatalogResource;

	@Test
	void shouldReturnMovieCatalog() {
		// given: An user name

		// when: Calls are made to ratings and info services
		List<CatalogItem> catalogItem = movieCatalogResource.getCatalog("100");

		// then: assert that a catalog is returned
		BDDAssertions.assertThat(catalogItem).isNotNull();

	}
}
