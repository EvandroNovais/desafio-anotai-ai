package com.eontecnologia.desafioanotaiai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories()
public class DesafioAnotaiAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioAnotaiAiApplication.class, args);
	}

}
