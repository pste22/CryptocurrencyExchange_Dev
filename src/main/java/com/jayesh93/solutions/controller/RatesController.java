package com.jayesh93.solutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh93.solutions.model.CryptoCurrencyRate;
import com.jayesh93.solutions.service.RaterService;

@RestController
@RequestMapping("/rates")
public class RatesController {

	@Autowired
	private RaterService service;

	@GetMapping
	public List<CryptoCurrencyRate> getPrices() {
		return service.getRates();
	}
}
