package com.assignment.currencyExchange.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.assignment.currencyExchange.model.Action;
import com.assignment.currencyExchange.model.Actions;
import com.assignment.currencyExchange.model.Currency;
import com.assignment.currencyExchange.model.CurrentMarket;
import com.assignment.currencyExchange.model.Trade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MarketStrategyImpl implements MarketStrategy {

	@Override
	public Actions calculateStrategy(String inputCurrency, CurrentMarket currentMarket)
			throws JsonProcessingException {

		Currency highestCurrency = currentMarket.getCurrency().get(0);
		Actions actions = new Actions();
		List<Action> listOfAction = new ArrayList<Action>();
		List<String> currencies = new ArrayList<>();

		for (Currency currency : currentMarket.getCurrency()) {
			if (highestCurrency.getPrice() < currency.getPrice()) {
				highestCurrency = currency;
			}
			currencies.add(currency.getCurrencyName());
		}
		// System.out.println("Highest Currency : "+ highestCurrency.getCurrencyName());
		if (currencies.contains(inputCurrency)) {
			while (!inputCurrency.equals(highestCurrency.getCurrencyName())) {
				for (Trade trade1 : currentMarket.getTrade()) {
					if (inputCurrency.equals(trade1.getTake())
							&& !inputCurrency.equals(highestCurrency.getCurrencyName())) {
						Action action = new Action(Constants.ACTION_TRADE, trade1.getGive(), inputCurrency, null,
								0.0);
						listOfAction.add(action);

						// System.out.println("Take " + inputCurrencyName + " and give " +
						// trade1.getGive());
						inputCurrency = trade1.getGive();
					}
				}
			}

			// System.out.println("Sell Currency: " + highestCurrency.getCurrencyName() + "
			// with price : "
			// + highestCurrency.getPrice());
			Action action = new Action(Constants.ACTION_SELL, null, null, highestCurrency.getCurrencyName(),
					highestCurrency.getPrice());
			listOfAction.add(action);
		}
		/*
		 * for(Action action1 : listOfAction) { System.out.println(action1); }
		 */
		actions.setActions(listOfAction);
		return actions;
	}

	public CurrentMarket parseCurrentMarketJsonToObject(ObjectMapper objectMapper)
			throws IOException, StreamReadException, DatabindException {
		CurrentMarket currentMarket = objectMapper
				.readValue(new ClassPathResource(Constants.AVAILABLE_MARKET_JSON).getFile(), CurrentMarket.class);
		return currentMarket;
	}
}