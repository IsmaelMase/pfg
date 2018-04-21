package com.ismaelmasegosa.salerev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SalerevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalerevApplication.class, args);
	}
}
