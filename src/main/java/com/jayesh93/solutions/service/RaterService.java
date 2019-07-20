package com.jayesh93.solutions.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh93.solutions.facade.RaterFacade;
import com.jayesh93.solutions.model.CryptoCurrencyRate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RaterService {

	@Autowired
	private RaterFacade facade;

	public List<CryptoCurrencyRate> getRates() {

		log.info("Service Invoked!");
		return facade.getRates()
				.getResult()
				.entrySet()
				.stream()
				.map(entry -> {
					entry.getValue()
							.setAlias(entry.getKey());
					return entry;
				})
				.map(entry -> entry.getValue())
				.collect(Collectors.toList());
	}
}
