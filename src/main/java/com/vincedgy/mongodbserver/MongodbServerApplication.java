package com.vincedgy.mongodbserver;

import com.vincedgy.mongodbserver.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbServerApplication {

	@Autowired
	UsersRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(MongodbServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (){
		Logger logger = LoggerFactory.getLogger(MongodbServerApplication.class);
		logger.info("Inserting one document...");
		return args -> {

			var user = User.builder()
					.email("vincent.dagoury+2@gmail.com")
					.firstName("Vincent")
					.lastName("Dagoury")
					.build();
			// repository.save(user);
		};
	}

}
