package com.assignment.currencyExchange.service;

import com.assignment.currencyExchange.model.Actions;
import com.assignment.currencyExchange.model.CurrentMarket;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MarketStrategy {

	Actions calculateStrategy(String inputCurrency, CurrentMarket currentMarket) throws JsonProcessingException;
}
