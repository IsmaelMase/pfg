package com.ismaelmasegosa.salerev;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ismaelmasegosa.salerev.service.serviceImpl.UploadService;

@SpringBootApplication
public class SalerevApplication {

	@Resource
	UploadService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SalerevApplication.class, args);
	}

}
