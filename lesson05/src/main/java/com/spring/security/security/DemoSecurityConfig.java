/**
 * 
 */
package com.spring.security.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.security.service.UserService;

/**
 * 
 */
@Configuration
public class DemoSecurityConfig {

	/*
	 * @Bean UserDetailsManager userDetail(DataSource dataSource) {
	 * JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
	 * manager.
	 * setUsersByUsernameQuery("SELECT user_id, pw, active FROM members where user_id = ?"
	 * ); manager.
	 * setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles where user_id = ?"
	 * ); return manager; }
	 */
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider(UserService userService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	SecurityFilterChain configuration(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(fillter -> fillter.requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE","MANAGER", "ADMIN")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE","MANAGER", "ADMIN")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
		http.httpBasic(Customizer.withDefaults());
		http.csrf(e -> e.disable());

		return http.build();

	}
}

/*
 * @Bean public InMemoryUserDetailsManager userDetailsManager() { UserDetails
 * john =
 * User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").
 * build(); UserDetails mary =
 * User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE",
 * "MANAGER") .build(); UserDetails susan =
 * User.builder().username("susan").password("{noop}test123") .roles("EMPLOYEE",
 * "MANAGER", "ADMIN").build(); return new InMemoryUserDetailsManager(john,
 * mary, susan); }
 */