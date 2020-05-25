package com.KWYE.UserAuthentication;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDb {
	
	@Bean
	CommandLineRunner initDb(UserRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new User("mani", "mani", 1234)));
		    log.info("Preloading " + repository.save(new User("kanta", "kanta", 5678)));
		};
	}
}
