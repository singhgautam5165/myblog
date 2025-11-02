package com.telecom.Telecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Enables component scan on subpackages
public class TelecomApplication {
	public static void main(String[] args) {
		SpringApplication.run(TelecomApplication.class, args);
	}
}