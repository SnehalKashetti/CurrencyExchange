package com.assignment.currencyExchange.model;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {

	@JsonProperty
	private String currencyName;
	@JsonProperty
	private Double price;

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Currency [currencyName=" + currencyName + ", price=" + price + "]";
	}

	@ConstructorProperties({ "currencyName", "price" })
	public Currency(String currencyName, Double price) {
		super();
		this.currencyName = currencyName;
		this.price = price;
	}

	public Currency() {
	}
}
