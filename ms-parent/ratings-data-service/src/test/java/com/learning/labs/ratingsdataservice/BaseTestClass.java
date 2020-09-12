package com.learning.labs.ratingsdataservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.learning.labs.ratingsdataservice.resources.RatingsResource;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(SpringExtension.class)  
@SpringBootTest
public class BaseTestClass {

	@Autowired
	RatingsResource ratingsResource;
	
	@BeforeEach
    public void setup() {
		RestAssuredMockMvc.standaloneSetup(ratingsResource);
    }
	
}
