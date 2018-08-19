package com.sivadas.anand.controller;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.sivadas.anand.domain.Quotes;
import com.sivadas.anand.service.SSEService;

@Controller
public class SSEClientController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SSEClientController.class);
	
	private ExecutorService nonBlockingService = Executors.newCachedThreadPool();	
	@Autowired
	private SSEService service;
	
	@RequestMapping("/")
	public String quotes(Model model) {
		
		return "quotes";
	}
	
	@GetMapping("/sse")
	public SseEmitter getSSE() {
		
		SseEmitter sseEmitter = new SseEmitter();
		nonBlockingService.execute(() -> {
			try {
				Quotes quote = service.getDailyQuotes();
				sseEmitter.send(quote);
				sseEmitter.complete();
			} catch (IOException exception) {
				LOGGER.error("Exception while server sent event send " + exception.getMessage());
				LOGGER.error("Exception while server sent event send ", exception);
				sseEmitter.completeWithError(exception);
			}
		});
		
		return sseEmitter;
	}
}
