package com.jayesh93.solutions.model;

import java.util.HashMap;

import lombok.Data;

@Data
public class CoinPaymentsResponse {
	private String error;
	private HashMap<String, CryptoCurrencyRate> result;
}
