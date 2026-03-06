package com.example.cabsystemsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CabSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner run(JdbcTemplate jdbcTemplate) {
		return args -> {
			try {
				jdbcTemplate.execute("ALTER TABLE users ADD COLUMN role VARCHAR(255) DEFAULT 'student'");
				System.out.println("Successfully added 'role' column to users table.");
			} catch (Exception e) {
				System.out.println("'role' column likely already exists or table doesn't exist yet: " + e.getMessage());
			}
		};
	}
}
