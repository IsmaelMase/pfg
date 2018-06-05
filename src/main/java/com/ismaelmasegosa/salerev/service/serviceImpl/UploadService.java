package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("uploadService")
public class UploadService {
	private final Path rootLocation = Paths.get("src/main/resources/upload-dir");

	public ResponseEntity<String> store(MultipartFile file) {
		try {
			if (Files.exists(Paths.get("src/main/resources/upload-dir" + file.getOriginalFilename()))) {
				return ResponseEntity.status(HttpStatus.FOUND).body("Fallo");
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			return ResponseEntity.status(HttpStatus.OK).body("ok");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Fallo");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("No se encontro la imagen");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Fallo");
		}
	}

	public void init() {
		try {
			if (!Files.exists(rootLocation)) {
				Files.createDirectory(rootLocation);

			}
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
