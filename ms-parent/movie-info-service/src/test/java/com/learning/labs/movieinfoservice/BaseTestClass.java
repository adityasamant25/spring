package com.learning.labs.movieinfoservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.learning.labs.movieinfoservice.resources.MovieResource;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(SpringExtension.class)  
@SpringBootTest
public class BaseTestClass {

	@Autowired
	MovieResource movieResource;
	
	@BeforeEach
    public void setup() {
		RestAssuredMockMvc.standaloneSetup(movieResource);
    }
}
