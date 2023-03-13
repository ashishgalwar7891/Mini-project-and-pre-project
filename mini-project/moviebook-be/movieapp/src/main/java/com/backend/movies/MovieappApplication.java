package com.backend.movies;

import com.backend.movies.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean  filterUrl(){
		// returns list of Intercepted URLs along with verification process
		FilterRegistrationBean frb = new FilterRegistrationBean();
		// which verification process to be followed
		frb.setFilter(new JwtFilter());
		// which URLs to be intercepted
		// "/Movie-app-v1/get-add-users"
		frb.addUrlPatterns("/movie-app-v1/get-user-details","/movie-app-v1/add-movie-to-user",
				"/movie-app-v1/admin/add-new-movie","/movie-app-v1/admin/update-movie",
				"/movie-app-v1/admin/delete-movie","/movie-app-v1/delete-movie-to-user/{movieId}");
		return frb;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}

//  int add(int... nums){  }
//  sum=add(1,2,3,4);
// sum = add(3,4);

















/*
@Bean
	public FilterRegistrationBean jwtFilter(){
		// returns list of intercepted URLs with defined JwtFilter class
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/Movie-app-v1/get-all-users","/Movie-app-v1/add-Movie");
		return frb;
	}

 */