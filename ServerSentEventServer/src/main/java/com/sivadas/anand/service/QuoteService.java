package com.sivadas.anand.service;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.sivadas.anand.domain.Quotes;

@Component
public class QuoteService {
	
	private String[] QUOTE_STRINGS = {"With the new day comes new strength and new thoughts.",
			"The greatest remedy for anger is delay.",
			"Nobody can hurt me without my permission.",
			"Art is man's expression of his joy in labor.", 
			"The art of communication is the language of leadership.",
			"You will not be punished for your anger, you will be punished by your anger.",
			"We boil at different degrees.",
			"Silence is one of the hardest arguments to refute.", 
			"First they ignore you, then they laugh at you, then they fight you, then you win.",
			"A nation's culture resides in the hearts and in the soul of its people."};

	private String[] QUOTE_AUTHORS = {"Elanor Roosevelt",
			"Lucius Annaeus",
			"Mahatma Gandhi",
			"Henry Kissinger", 
			"James Humes",
			"Budhdha",
			"Client Eastwood",
			"Josh Billings", 
			"Mahatma Gandhi",
			"Mahatma Gandhi"};
	
	public Quotes getRandomQuoteOfTheDay() {
		
		Random random = new Random();
		int index = random.nextInt(10);
		
		Quotes quote = new Quotes();
		quote.setQuote(QUOTE_STRINGS[index]);
		quote.setAuthor(QUOTE_AUTHORS[index]);
		
		return quote;
	}
	
	

}
