package com.assignment.currencyExchange.model;

public class Trade {
	private String take;
	private String give;

	public String getTake() {
		return take;
	}

	public Trade(String take, String give) {
		super();
		this.take = take;
		this.give = give;
	}

	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setTake(String take) {
		this.take = take;
	}

	public String getGive() {
		return give;
	}

	public void setGive(String give) {
		this.give = give;
	}

}
