package com.cgonul.poc.springsecurity.basics.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;

import com.cgonul.poc.springsecurity.basics.persistence.InMemoryUserRepository;
import com.cgonul.poc.springsecurity.basics.persistence.UserRepository;
import com.cgonul.poc.springsecurity.basics.web.model.User;

@SpringBootApplication
@ComponentScan ("com.cgonul")
public class Application {

	interface StringUserConverter extends Converter<String, User> {
		//https://stackoverflow.com/questions/25711858/spring-cant-determine-generic-types-when-lambda-expression-is-used-instead-of-a
	}

	@Bean
	public UserRepository userRepository() {
		return new InMemoryUserRepository();
	}

	@Bean
	public StringUserConverter messageConverter() {
		return id -> userRepository().findUser(Long.valueOf(id));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
