package com.tlongueira.mensajeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tlongueira.mensajeria.*")
public class MensajeriaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensajeriaApiApplication.class, args);
	}

}
