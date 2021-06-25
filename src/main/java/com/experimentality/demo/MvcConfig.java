package com.experimentality.demo;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	//private final int MAX_AGE = 48000;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		String[] methods = { "POST", "GET", "PUT", "DELETE", "OPTIONS" };

		/*registry.addMapping("/api/**").allowedOrigins(VarCommon.IPS_VALIDAS).allowedMethods(methods).maxAge(MAX_AGE);
		registry.addMapping("/login**").allowedOrigins(VarCommon.IPS_VALIDAS).allowedMethods(methods).maxAge(MAX_AGE);

		registry.addMapping("/secured/**").allowedOrigins(VarCommon.IPS_VALIDAS).allowedMethods(methods)
				.maxAge(MAX_AGE);
*/
	}
	
	/*@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
}

