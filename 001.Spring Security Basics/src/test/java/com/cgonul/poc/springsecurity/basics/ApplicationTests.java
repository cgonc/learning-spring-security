package com.cgonul.poc.springsecurity.basics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgonul.poc.springsecurity.basics.spring.Application;

@RunWith (SpringRunner.class)
@SpringBootTest (classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
