package com.devsuperior.dsemailsender.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sendgrid.helpers.mail.Mail;

public class SendgridServiceDev extends SendgridServiceAbstract {

	private Logger LOG = LoggerFactory.getLogger(SendgridServiceDev.class);

	protected void callEmailAPI(Mail mail) {

		LOG.info("Sending mock email from: " + mail.getFrom().getEmail() + " like a dev");
		
	}
}
