package com.cgonul.poc.springsecurity.basics.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public SecurityConfig() {
		super();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off
        auth.
            inMemoryAuthentication().
            withUser("user").password("pass").
            roles("USER");
    } // @formatter:on

	@Override
	protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http
        .authorizeRequests()
                .anyRequest().authenticated()

        .and()
        .formLogin().
            loginPage("/login").permitAll().
            loginProcessingUrl("/doLogin")

        .and()
        .logout().permitAll().logoutUrl("/logout")
		//.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET")) //You can also determine the HTTP method of the logout action.
        .and()
        .csrf().disable() //For logout with GET request.
        ;
    } // @formatter:on


}
