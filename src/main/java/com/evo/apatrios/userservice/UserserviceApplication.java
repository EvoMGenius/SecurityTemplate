package com.evo.apatrios.userservice;

import com.evo.apatrios.userservice.domain.Role;
import com.evo.apatrios.userservice.domain.User;
import com.evo.apatrios.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Richard", "richy", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ted", "ted", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Apa", "apa", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("richy", "ROLE_MANAGER");
			userService.addRoleToUser("ted", "ROLE_ADMIN");
			userService.addRoleToUser("apa", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("apa", "ROLE_ADMIN");
			userService.addRoleToUser("apa", "ROLE_USER");
		};
	}
}
