package com.ismaelmasegosa.salerev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmasegosa.salerev.models.ChangePass;
import com.ismaelmasegosa.salerev.service.serviceImpl.MailService;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin("*")
public class MailController {
	@Autowired
	@Qualifier("mailService")
	private MailService mailService;

	@PostMapping(value = "/sendMail")
	public ResponseEntity<String> sendMail(@RequestBody ChangePass change) {
		return mailService.sendMail(change);
	}
}
