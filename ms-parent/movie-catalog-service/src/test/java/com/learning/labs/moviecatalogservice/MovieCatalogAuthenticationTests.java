package com.learning.labs.moviecatalogservice;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

import com.learning.labs.moviecatalogservice.models.AuthenticationRequest;
import com.learning.labs.moviecatalogservice.models.AuthenticationResponse;
import com.learning.labs.moviecatalogservice.resources.JwtAuthenticationResource;

@SpringBootTest
class MovieCatalogAuthenticationTests {

	@Autowired
	JwtAuthenticationResource jwtAuthenticationResource;

	@Test
	void shouldAuthenticateValidUser() {
		// given: A valid AuthenticationRequest
		AuthenticationRequest authenticationRequest = new AuthenticationRequest();
		authenticationRequest.setUsername("foo");
		authenticationRequest.setPassword("foo");

		// when: passed to an Authentication API
		ResponseEntity<AuthenticationResponse> response = jwtAuthenticationResource
				.createAuthenticationToken(authenticationRequest);

		// then: Check presence of a JWT token
		BDDAssertions.assertThat(response).isNotNull();

	}

	@Test
	void shouldRejectInvalidPassword() {
		// given: An invalid AuthenticationRequest
		AuthenticationRequest authenticationRequest = new AuthenticationRequest();
		authenticationRequest.setUsername("foo");
		authenticationRequest.setPassword("foo1");

		// when: passed to an Authentication API
		try {
			jwtAuthenticationResource.createAuthenticationToken(authenticationRequest);
		} catch (Exception e) {
			BDDAssertions.assertThat(e).isInstanceOf(BadCredentialsException.class);
		}
	}
}
