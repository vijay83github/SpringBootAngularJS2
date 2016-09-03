/*package com.appdirect.user.configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class YakshopWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter  {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		ResourceHandlerRegistration resourceRegistration = registry
	            .addResourceHandler("resources/**");
		resourceRegistration.addResourceLocations("/resources/**");
		//resourceRegistration.addResourceLocations("/resources/static/**");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/**");
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/**");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/**");
        registry.addResourceHandler("/**").addResourceLocations("/resources/views/**");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/static/css/**");
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/static/img/**");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/static/js/**");
        registry.addResourceHandler("/**").addResourceLocations("/resources/static/views/**");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/resources/"); 
        registry.addResourceHandler("/resources/static/**")
        .addResourceLocations("classpath:/resources/static/"); 

	}

	

}
*/