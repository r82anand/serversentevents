package com.sivadas.anand.util;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivadas.anand.domain.Quotes;

public class SSEClientUtil {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SSEClientUtil.class);
	
	public static Quotes translateJSONToQuote(String jsonString) {
		
		Quotes quote = new Quotes();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			quote.setQuote(jsonObject.isNull("quote") ? StringUtils.EMPTY : jsonObject.getString("quote"));
			quote.setAuthor(jsonObject.isNull("author") ? StringUtils.EMPTY : jsonObject.getString("author"));

			
		} catch (JSONException jsonException) {
			LOGGER.error("JSONException occurred : " + jsonException.getMessage());
			LOGGER.error("JSONException occurred : ", jsonException);
		}
		
		return quote;
	}

}
