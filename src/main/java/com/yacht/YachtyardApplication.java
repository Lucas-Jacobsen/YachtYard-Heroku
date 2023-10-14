package com.yacht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.yacht.data")
@ComponentScan("com.yacht") // Make sure the package is correctly set
public class YachtyardApplication {

	public static void main(String[] args) {

		SpringApplication.run(YachtyardApplication.class, args);
	}

}
