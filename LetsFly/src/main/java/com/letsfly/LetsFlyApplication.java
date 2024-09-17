package com.letsfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LetsFlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsFlyApplication.class, args);
		System.out.println("We are live");
		System.out.println("http://localhost:8080/");
	}

}
