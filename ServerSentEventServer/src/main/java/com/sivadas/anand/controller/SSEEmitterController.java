package com.sivadas.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.domain.Quotes;
import com.sivadas.anand.service.QuoteService;

@RestController
public class SSEEmitterController {

	@Autowired
	private QuoteService quoteService;

	@GetMapping("/quote")
	public Quotes getNewMessage() {

		Quotes randomQuoteOfTheDay = quoteService.getRandomQuoteOfTheDay();

		return randomQuoteOfTheDay;
	}

}
