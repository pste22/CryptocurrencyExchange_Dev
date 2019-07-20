package com.jayesh93.solutions.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.jayesh93.solutions.model.CoinPaymentsResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RaterFacade {

	private static final String ENDPOINT = "https://www.coinpayments.net/api.php";

	private static final String VERSION = "1";

	private static final String COMMAND_VALUE = "rates";

	private static final String PRIVATE_KEY_VALUE = "64aa564865518060dad334b0259e9dfea96711e64f36e429adbb7d8453665f68";

	private static final String FORMAT_VALUE = "json";

	private static final String HMAC_VALUE = "4e908796d1f7cbd8fd864dead6b44dfae13d4ce9e7a71afb67712be8ab7815374bbf2a82fff972a680b7b6382d31bd84020756e88977eb6224f510164be54fdf";

	@Autowired
	private RestTemplate restTemplate;

	public CoinPaymentsResponse getRates() {

		log.info("Pulling Data from CoinPayments Service");
		ResponseEntity<CoinPaymentsResponse> responseEntity = restTemplate.postForEntity(ENDPOINT, getPostEntities(),
				CoinPaymentsResponse.class);

		if (!HttpStatus.OK.equals(responseEntity.getStatusCode())) {
			log.info("Error Occurred while Consuming CoinPayments API, Response Status is {}",
					responseEntity.getStatusCodeValue());
			throw new RuntimeException("Could not retrieve data from CoinPayments");
		}

		log.info("Data successfully retrieved from CoinPayments");
		return responseEntity.getBody();
	}

	public HttpHeaders getAPIHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("HMAC", HMAC_VALUE);
		return headers;
	}

	public HttpEntity<MultiValueMap<String, String>> getPostEntities() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("version", VERSION);
		map.add("cmd", COMMAND_VALUE);
		map.add("key", PRIVATE_KEY_VALUE);
		map.add("format", FORMAT_VALUE);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
				getAPIHeaders());
		return request;
	}
}