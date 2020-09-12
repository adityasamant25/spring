package com.learning.labs.moviecatalogservice;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.labs.moviecatalogservice.services.MyUserDetailsService;
import com.learning.labs.moviecatalogservice.utils.JwtUtil;

@SpringBootTest
class JwtUtilsTest {

	@Autowired
	JwtUtil jwtUtil; 
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Test
	void testGenerateToken() {
		
		String token = jwtUtil.generateToken(userDetailsService.loadUserByUsername("foo"));
		BDDAssertions.assertThat(token).startsWith("ey");
	}
	
	@Test
	void testGenerateAndValidateToken() {
		
		String token = jwtUtil.generateToken(userDetailsService.loadUserByUsername("foo"));
		BDDAssertions.assertThat(token).startsWith("ey");
		
		Boolean isValid = jwtUtil.validateToken(token);
		BDDAssertions.assertThat(isValid).isTrue();
	}
	
	@Test
	void testGenerateTokenAndExtractUsername() {
		
		String token = jwtUtil.generateToken(userDetailsService.loadUserByUsername("foo"));
		BDDAssertions.assertThat(token).startsWith("ey");
		
		String username = jwtUtil.extractUsername(token);
		BDDAssertions.assertThat(username).isEqualTo("foo");
	}
	
	@Test
	void testGenerateAndCheckTokenNotExpired() {
		
		String token = jwtUtil.generateToken(userDetailsService.loadUserByUsername("foo"));
		jwtUtil.isTokenExpired(token);
		BDDAssertions.assertThat(token).startsWith("ey");
	}
}
