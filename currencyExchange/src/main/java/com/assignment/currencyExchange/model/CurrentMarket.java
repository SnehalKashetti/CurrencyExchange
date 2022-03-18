package com.assignment.currencyExchange.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentMarket {

	@JsonProperty
	private List<Currency> currencies;
	@JsonProperty
	private List<Trade> trades;

	public CurrentMarket() {
		super();
	}

	public List<Currency> getCurrency() {
		return currencies;
	}

	public void setCurrency(List<Currency> currencies) {
		this.currencies = currencies;
	}

	public List<Trade> getTrade() {
		return trades;
	}

	public CurrentMarket(List<Currency> currencies, List<Trade> trades) {
		super();
		this.currencies = currencies;
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "CurrentMarket [currency=" + currencies + ", trade=" + trades + "]";
	}

	public void setTrade(List<Trade> trades) {
		this.trades = trades;
	}

}
