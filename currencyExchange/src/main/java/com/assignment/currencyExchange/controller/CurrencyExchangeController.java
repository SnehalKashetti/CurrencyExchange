package com.assignment.currencyExchange.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.currencyExchange.model.Actions;
import com.assignment.currencyExchange.model.CurrentMarket;
import com.assignment.currencyExchange.service.MarketStrategyImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController

public class CurrencyExchangeController {

	/**
	 * Gets users by id.
	 *
	 * @param inputCurrency the inputCurrency
	 * @return the actions
	 * @throws IOException
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/exchangeStrategy/{inputCurrency}")
	public ResponseEntity<Actions> getUsersById(@PathVariable(value = "inputCurrency") String inputCurrency)
			throws IOException {
		HttpStatus status = HttpStatus.OK;
		ObjectMapper objectMapper = new ObjectMapper();
		MarketStrategyImpl marketStrategy = new MarketStrategyImpl();

		CurrentMarket currentMarket = marketStrategy.parseCurrentMarketJsonToObject(objectMapper);
		Actions actions = marketStrategy.calculateStrategy(inputCurrency, currentMarket);

		if (actions == null) {
			status = HttpStatus.NOT_FOUND;
		}

		return ResponseEntity.status(status).body(actions);
	}
}
