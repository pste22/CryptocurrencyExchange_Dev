package com.jayesh93.solutions.model;

import lombok.Data;

@Data
public class CryptoCurrencyRate {

	private String alias;
	
	private String name;

	private String rate_btc;

	private String last_update;

	private String tx_fee;

	private String status;

	private String confirms;

	private String explorer;

	private int can_convert;
}