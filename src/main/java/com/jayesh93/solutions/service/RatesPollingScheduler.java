package com.jayesh93.solutions.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RatesPollingScheduler {

	@Autowired
	private RaterService ratesService;

	@Scheduled(cron = "* * * * * *")
	private void getRates() {
		log.info("Scheduler Invoked at {} to retriee the rates from CoinPayments API!", LocalDateTime.now());
		ratesService.getRates();
		log.info("Rates Retrieval Process Completed at {}", LocalDateTime.now());
	}

}
