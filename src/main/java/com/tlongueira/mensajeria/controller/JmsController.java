package com.tlongueira.mensajeria.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlongueira.mensajeria.dto.Notificacion;

@RestController
@RequestMapping("/jms")
public class JmsController {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;
	@Autowired
	private Queue Jsonqueue;

	@PostMapping("/message")
	public String sendMessage() {
		try {
			jmsTemplate.convertAndSend(queue, "Cositas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Cositas";
	}
	@GetMapping("/message")
	public String consumeMessage() {
		String message = "";
		try {
			String jsonMessage = (String) jmsTemplate.receiveAndConvert(queue);
			message = jsonMessage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	@PostMapping("/message/json")
	public Notificacion sendMessageJson(@RequestBody Notificacion notificacion) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String notificacionAsJson = mapper.writeValueAsString(notificacion);
			jmsTemplate.convertAndSend(Jsonqueue, notificacionAsJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notificacion;
	}
	@GetMapping("/message/json")
	public Notificacion consumeMessageJson() {

		Notificacion notificacion = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonMessage = (String) jmsTemplate.receiveAndConvert(Jsonqueue);
			notificacion = mapper.readValue(jsonMessage, Notificacion.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return notificacion;
	}
}
