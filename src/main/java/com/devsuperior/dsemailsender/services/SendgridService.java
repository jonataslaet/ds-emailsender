package com.devsuperior.dsemailsender.services;

import com.devsuperior.dsemailsender.controllers.dtos.EmailDTO;
import com.sendgrid.helpers.mail.Mail;

public interface SendgridService {

	void sendEmail(EmailDTO dto);

	Mail prepareEmail(EmailDTO dto);

}
