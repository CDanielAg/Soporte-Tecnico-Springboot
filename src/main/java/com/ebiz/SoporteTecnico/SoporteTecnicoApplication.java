package com.ebiz.SoporteTecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SoporteTecnicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoporteTecnicoApplication.class, args);
	}

}
