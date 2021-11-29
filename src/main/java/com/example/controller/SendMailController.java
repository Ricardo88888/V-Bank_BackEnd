package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SendMail;
import com.example.service.SendMailService;

@RestController
@RequestMapping( path = "/sendMail/")
@CrossOrigin(origins = "http://localhost:4200")
public class SendMailController {

	@Autowired
	SendMailService service;
	
	@PostMapping
	public String correo(@RequestBody SendMail request) {
		return service.enviarMail(request);
	}
	
}
