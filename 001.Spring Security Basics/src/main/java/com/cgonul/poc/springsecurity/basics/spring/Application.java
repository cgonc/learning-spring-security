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
@ComponentScan("com.cgonul")
public class Application {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public Converter<String, User> messageConverter() {
        return new Converter<String, User>() {
            @Override
            public User convert(String id) {
                return userRepository().findUser(Long.valueOf(id));
            }
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
