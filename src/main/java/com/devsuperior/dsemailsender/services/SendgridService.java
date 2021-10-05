package com.devsuperior.dsemailsender.services;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.devsuperior.dsemailsender.controllers.dtos.EmailDTO;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class SendgridService {

	private Logger LOG = LoggerFactory.getLogger(SendgridService.class);

	@Autowired
	private Environment env;

	public void sendEmail(EmailDTO dto) {
		Mail mail = prepareEmail(dto);
		callEmailAPI(mail);
	}

	public Mail prepareEmail(EmailDTO dto) {
		Email from = new Email(dto.getFromEmail(), dto.getFromName());
		Email to = new Email(dto.getTo());
		Content content = new Content(dto.getContentType(), dto.getBody());
		Mail mail = new Mail(from, dto.getSubject(), to, content);
		mail.setReplyTo(new Email(dto.getReplyTo()));
		return mail;
	}

	protected void callEmailAPI(Mail mail) {

		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			LOG.info("Sending mock email from: " + mail.getFrom().getEmail() + " like a test");
		} else if (Arrays.asList(env.getActiveProfiles()).contains("dev")) {
			LOG.info("Sending mock email from: " + mail.getFrom().getEmail() + " like a dev");
		}
	}
}
