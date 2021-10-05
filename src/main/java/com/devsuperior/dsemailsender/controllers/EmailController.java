package com.devsuperior.dsemailsender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsemailsender.controllers.dtos.EmailDTO;
import com.devsuperior.dsemailsender.services.SendgridService;

@RestController
@RequestMapping(value = "/emails")
public class EmailController {

	@Autowired
	private SendgridService service;
	
	@PostMapping
	public ResponseEntity<EmailDTO> insert(@RequestBody EmailDTO dto) {
		service.sendEmail(dto);
		return ResponseEntity.noContent().build();
	}
}
