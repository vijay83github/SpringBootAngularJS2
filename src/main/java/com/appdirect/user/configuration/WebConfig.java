package com.appdirect.user.configuration;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig{

	@Bean
	public Filter cORSFilter(){
		return new CORSFilter();
	}
}
