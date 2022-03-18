package com.assignment.currencyExchange.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actions {

	@JsonProperty
	private List<Action> actions;

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Actions() {
		super();
	}

	public Actions(List<Action> actions) {
		super();
		this.actions = actions;
	}
}
