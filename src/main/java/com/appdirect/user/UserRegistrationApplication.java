package com.appdirect.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class UserRegistrationApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(UserRegistrationApplication.class);
		application.run(args);

	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*ResourceHandlerRegistration resourceRegistration = registry
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
                .addResourceLocations("classpath:/resources/"); */
        /*registry.addResourceHandler("/resources/static/**")
        .addResourceLocations("classpath:/resources/static/"); */

	}

}
