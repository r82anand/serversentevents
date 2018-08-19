package com.sivadas.anand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sivadas.anand.domain.Quotes;
import com.sivadas.anand.util.SSEClientUtil;

@Service
public class SSEService {

	@Value("${sse.server.url}")
	private String sseEventServerURL;

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}

	public Quotes getDailyQuotes() {
		String jsonString = getRestTemplate().getForObject(sseEventServerURL, String.class);
		Quotes quote = SSEClientUtil.translateJSONToQuote(jsonString);
		
		return quote;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
