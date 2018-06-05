package org.geometricshapes.intersections;

import org.geometricshapes.intersections.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
@SpringBootApplication(scanBasePackages = "org.geometricshapes.intersections")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			userRepository.save(new User("username", "password"));
		};
	}
}
