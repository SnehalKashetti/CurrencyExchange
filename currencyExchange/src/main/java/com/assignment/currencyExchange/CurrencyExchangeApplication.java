package com.assignment.currencyExchange;

import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import com.assignment.currencyExchange.model.*;
import com.assignment.currencyExchange.service.Constants;
import com.assignment.currencyExchange.service.MarketStrategyImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class CurrencyExchangeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); MarketStrategyImpl
		 * marketStrategy = new MarketStrategyImpl();
		 */
        SpringApplication.run(CurrencyExchangeApplication.class, args);  

		/*
		 * CurrentMarket currentMarket = parseCurrentMarketJsonToObject(objectMapper);
		 * 
		 * Currency inputCurrency = parseInputCurrencyJsonToObject(objectMapper);
		 * 
		 * Actions actions = marketStrategy.calculateStrategy(inputCurrency,
		 * currentMarket);
		 */

		/*
		 * String json = printJsonToConsole(objectMapper, actions);
		 * 
		 * writeJsonToFile(json);
		 */
	}

	/**
	 * @param objectMapper
	 * @return
	 * @throws IOException
	 * @throws StreamReadException
	 * @throws DatabindException
	 */
	private static Currency parseInputCurrencyJsonToObject(ObjectMapper objectMapper)
			throws IOException, StreamReadException, DatabindException {
		Currency inputCurrency = objectMapper
				.readValue(new ClassPathResource(Constants.INPUT_CURRENCY_JSON).getFile(), Currency.class);
		return inputCurrency;
	}

	/**
	 * @param objectMapper
	 * @return
	 * @throws IOException
	 * @throws StreamReadException
	 * @throws DatabindException
	 */
	private static CurrentMarket parseCurrentMarketJsonToObject(ObjectMapper objectMapper)
			throws IOException, StreamReadException, DatabindException {
		CurrentMarket currentMarket = objectMapper
				.readValue(new ClassPathResource(Constants.AVAILABLE_MARKET_JSON).getFile(), CurrentMarket.class);
		return currentMarket;
	}

	/**
	 * @param objectMapper
	 * @param actions
	 * @return
	 * @throws JsonProcessingException
	 */
	private static String printJsonToConsole(ObjectMapper objectMapper, Actions actions)
			throws JsonProcessingException {
		ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(actions);

		System.out.println(json);
		return json;
	}

	/**
	 * @param json
	 * @throws IOException
	 */
	private static void writeJsonToFile(String json) throws IOException {
		FileWriter file = new FileWriter(Constants.OUTPUT_JSON);
		file.write(json.toString());
		file.close();
	}

}
