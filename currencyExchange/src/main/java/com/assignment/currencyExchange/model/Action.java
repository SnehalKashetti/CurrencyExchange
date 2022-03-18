package com.assignment.currencyExchange.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Action {

	private String action;
	private String give;
	private String take;
	private String currencyName;
	private double price;

	public Action(String action, String give, String take, String currencyName, double price) {
		super();
		this.action = action;
		this.give = give;
		this.take = take;
		this.currencyName = currencyName;
		this.price = price;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getGive() {
		return give;
	}

	public void setGive(String give) {
		this.give = give;
	}

	public String getTake() {
		return take;
	}

	public void setTake(String take) {
		this.take = take;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public Action() {
		super();
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
