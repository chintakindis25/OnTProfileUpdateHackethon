package com.ont.profiles.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	@Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder){
		
		UserDetails staff = User.withUsername("Shweta")
					.password(passwordEncoder.encode("shweta"))
				.roles("STAFF").build();
		
		UserDetails admin = User.withUsername("Riya")
				.password(passwordEncoder.encode("riya"))
			.roles("ADMIN").build();
		
		
		return new InMemoryUserDetailsManager(staff,admin);
		
		
	}

	@SuppressWarnings({ "deprecation", "removal" })
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.requestMatchers("/addProfile").hasRole("STAFF")
				.requestMatchers("/updateProfile").hasAnyRole("ADMIN","STAFF")
				.anyRequest().authenticated().and().httpBasic();
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder;

	}

}