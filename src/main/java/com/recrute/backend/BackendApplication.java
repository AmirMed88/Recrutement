package com.recrute.backend;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.recrute.backend.Services.EmailSenderService;

@SpringBootApplication
public class BackendApplication {


	// @Autowired
	// private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	// @EventListener(ApplicationReadyEvent.class)
	// public void triggerMail() throws MessagingException {
	// 	senderService.sendSimpleEmail("amirmouhamed013@gmail.com",
	// 			"This is email body",
	// 			"This is email subject");

	// }

}
